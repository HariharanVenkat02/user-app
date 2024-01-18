package com.example.xpaybackuserapp.UI

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.xpaybackuserapp.Data.UserDetailsModel
import com.example.xpaybackuserapp.Network.ApiService
import com.example.xpaybackuserapp.Repositary.UserRepositary
import com.example.xpaybackuserapp.Utils.ViewModelFactory
import com.example.xpaybackuserapp.ViewModel.UserListViewModel
import com.example.xpaybackuserapp.databinding.ActivityUserDeatilsBinding


class UserDeatilsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressDialog: ProgressDialog
    private lateinit var binding: ActivityUserDeatilsBinding
    lateinit var viewmodel: UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDeatilsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listener()
        val data = intent.getIntExtra("id", 0)
        val repository = UserRepositary(ApiService())
        progressDialog = ProgressDialog(this).apply {
            setMessage("Loading ..")
            setCancelable(false)
        }
        viewmodel =
            ViewModelProvider(this, ViewModelFactory(repository)).get(UserListViewModel::class.java)

        viewmodel.specificUserList.observe(this, Observer { userDetails ->
            setUI(userDetails)
        })
        fetchData(data)
    }

    private fun listener() {
        with(binding){
                btnAdsDown.setVisibilityController(layoutAddressDetails, btnAdsDown, btnAdsUp)
                btnBankDown.setVisibilityController(layoutBankDetails, btnBankDown, btnBankUp)
                btnCmpDown.setVisibilityController(layoutCompanyDetails, btnCmpDown, btnCmpUp)
                btnCryptoDown.setVisibilityController(layoutCryptoDetails, btnCryptoDown, btnCryptoUp)
        }
    }

    private fun fetchData(data: Int) {
        progressDialog.show()
        data?.let { viewmodel.fetchUserDetails(it) }
    }

    private fun setUI(userDetails: UserDetailsModel?) {
        progressDialog.dismiss()
        with(binding) {
            txtName.text = "${userDetails?.firstName} ${userDetails?.middleName} ${userDetails?.lastName}"
            txtAge.text = userDetails?.age.toString()
            txtDob.text = userDetails?.dob
            txtEmail.text = userDetails?.email
            txtPhone.text = userDetails?.phone
            txtGender.text = userDetails?.gender
            txtHaircolor.text = userDetails?.hair?.color
            txtHairtype.text = userDetails?.hair?.type
            txtEyecolor.text = userDetails?.eyeColor
            txtHeight.text = userDetails?.height.toString()
            txtWeight.text = userDetails?.weight.toString()

            //address
            val address = userDetails?.address
            txtAddress.text = address?.address
            txtCity.text = address?.city
            txtPostalcode.text = address?.postalCode
            txtState.text = address?.state
            txtMacAddress.text = userDetails?.macAddress
            txtGeocordinates.text = address?.geoCoordinates?.latitude.toString()
                .plus(address?.geoCoordinates?.longitude.toString())
            //company
            val company = userDetails?.company
            val geolimit =company?.address?.geoCoordinates
            txtCompanyName.text = company?.name
            txtRole.text = company?.title
            txtDepartment.text = company?.department
            txtCompAddress.text = company?.address?.address
            txtCmpGeolimit.text =
                "${geolimit?.latitude} ${geolimit?.longitude}"
            //bank
            val bank =userDetails?.bank
            txtCardnum.text = bank?.cardNumber
            txtCardtype.text = bank?.cardType
            txtCardexpire.text = bank?.cardExpire
            txtCurrency.text = bank?.currency
            txtIban.text = bank?.iban

            //crypto
            val crypto =userDetails?.crypto
            txtCoin.text = crypto?.coin
            txtWallet.text = crypto?.wallet
            txtNetwork.text = crypto?.network
        }

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}

private fun ImageView.setVisibilityController(
    detailsLayout: LinearLayout,
    btnAdsDown: ImageView,
    btnAdsUp: ImageView
) {
    setOnClickListener {
        if (visibility == ImageView.VISIBLE) {
            detailsLayout.visibility = LinearLayout.VISIBLE
            visibility = ImageView.GONE
        } else {
            detailsLayout.visibility = LinearLayout.GONE
            visibility = ImageView.VISIBLE
        }
    }
    btnAdsUp.setOnClickListener {
        detailsLayout.visibility = LinearLayout.GONE
        btnAdsDown.visibility = ImageView.VISIBLE
    }
}
