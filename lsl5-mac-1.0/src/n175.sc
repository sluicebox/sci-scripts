;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 175)
(include sci.sh)
(use Main)
(use Interface)
(use File)

(public
	PasswordTest 0
)

(local
	[local0 10]
	[local10 10]
	local20
)

(procedure (localproc_0)
	(if (and (IsObject gFastCast) (gFastCast elements:))
		(gFastCast eachElementDo: #dispose 1)
	)
	(if (and (IsObject gCast) (gCast elements:))
		(gCast eachElementDo: #dispose 1)
	)
)

(procedure (PasswordTest &tmp rc result)
	(localproc_0)
	(DrawPic 110)
	(LoadPassword)
	(if (StrCmp @local10 {NONE})
		(= local0 0)
	else
		(StrCpy @local0 @local10)
	)
	(while
		(and
			(< local20 5)
			(or (not (= rc (AskPassword))) (StrCmp @local10 @local0))
		)
	)
	(cond
		((== local20 5)
			(Print 175 0 #title {Five Strikes and You're Out!}) ; "I'm sorry, but you have failed to enter the correct password for this game. Please try again when you know the password."
			(= gQuit 1)
			(gGame quitGame: 1)
		)
		((== rc 2)
			(GetInput @local0 20 {Please enter your new password:})
			(ConvertCase)
			(StrCpy @local10 @local0)
			(SavePassword)
			(Printf 175 1 @local0 80 {Write this down!}) ; "Your password is now %s. Don't forget it!"
		)
	)
	(DisposeScript 993)
	(return result) ; UNINIT
)

(procedure (AskPassword &tmp rc)
	(if (not (StrCmp @local10 {NONE}))
		(= rc
			(Print
				{If you would like to use a\npassword to protect this game,\nselect "Password" below.}
				106
				81
				{Why bother?}
				1
				81
				{Password}
				2
				80
				{An ounce of prevention...}
				70
				160
				67
				3
				-1
			)
		)
	else
		(++ local20)
		(= rc
			(Print
				{Please enter your password,\nexactly as you typed it:}
				106
				41
				@local0
				20
				106
				81
				{Ok}
				1
				81
				{Change}
				2
				80
				{Hey! Is that you again?}
				70
				160
				67
				3
				-1
			)
		)
	)
	(ConvertCase)
	(return rc)
)

(procedure (ConvertCase &tmp i char)
	(for ((= i 0)) (< i (StrLen @local0)) ((++ i))
		(if (> (= char (StrAt @local0 i)) 90)
			(StrAt @local0 i (- char 32))
		)
	)
)

(procedure (Hash &tmp i char seed)
	(for ((= i 0)) (< i (StrLen @local10)) ((++ i))
		(= seed (- 167 i))
		(= char (^ (StrAt @local10 i) seed))
		(StrAt @local10 i char)
	)
)

(procedure (LoadPassword &tmp [str 10])
	(if (!= (MEMORY_DRV open: 1) 0)
		(MEMORY_DRV readString: @local10 20 read: @str 8 close:)
		(= gPokerJackpot (ReadNumber @str))
	)
	(Hash)
)

(procedure (SavePassword &tmp [str 10])
	(if (!= (MEMORY_DRV open: 2) 0)
		(Hash)
		(Format @str 175 2 gPokerJackpot) ; "%d"
		(MEMORY_DRV
			writeString: @local10
			writeString: {\n}
			writeString: @str
			close:
		)
	)
)

(instance MEMORY_DRV of File
	(properties
		name {MEMORY.DRV}
	)
)

