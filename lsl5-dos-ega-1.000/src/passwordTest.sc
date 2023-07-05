;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 155)
(include sci.sh)
(use Main)
(use Interface)
(use File)
(use Game)

(public
	passwordTest 0
)

(local
	[passStr 10]
	[realStr 10]
	theCount
)

(procedure (AskPassword &tmp rc)
	(if (not (StrCmp @realStr {NONE}))
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
		(++ theCount)
		(= rc
			(Print
				{Please enter your password,\nexactly as you typed it:}
				106
				41
				@passStr
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
	(for ((= i 0)) (< i (StrLen @passStr)) ((++ i))
		(if (> (= char (StrAt @passStr i)) 90)
			(StrAt @passStr i (- char 32))
		)
	)
)

(procedure (Hash &tmp i char seed)
	(for ((= i 0)) (< i (StrLen @realStr)) ((++ i))
		(= seed (- 167 i))
		(= char (^ (StrAt @realStr i) seed))
		(StrAt @realStr i char)
	)
)

(procedure (LoadPassword &tmp [str 10])
	(if (!= (MEMORY_DRV open: 1) 0)
		(MEMORY_DRV readString: @realStr 20 read: @str 8 close:)
		(= gPokerJackpot (ReadNumber @str))
	)
	(Hash)
)

(procedure (SavePassword &tmp [str 10])
	(if (!= (MEMORY_DRV open: 2) 0)
		(Hash)
		(Format @str 155 3 gPokerJackpot) ; "%d"
		(MEMORY_DRV
			writeString: @realStr
			writeString: {\n}
			writeString: @str
			close:
		)
	)
)

(instance passwordTest of Rm
	(properties
		picture 110
		style 7
	)

	(method (init &tmp rc)
		(super init:)
		(LoadPassword)
		(if (StrCmp @realStr {NONE})
			(= passStr 0)
		else
			(StrCpy @passStr @realStr)
		)
		(while
			(and
				(< theCount 5)
				(or (not (= rc (AskPassword))) (StrCmp @realStr @passStr))
			)
		)
		(cond
			((== theCount 5)
				(Print 155 0 #title {Five Strikes and You're Out!}) ; "I'm sorry, but you have failed to enter the correct password for this game. Please try again when you know the password."
				(= gQuit 1)
				(return)
			)
			((== rc 2)
				(GetInput @passStr 20 {Please enter your new password:})
				(ConvertCase)
				(StrCpy @realStr @passStr)
				(SavePassword)
				(Printf 155 1 @passStr 80 {Write this down!}) ; "Your password is now %s. Don't forget it!"
			)
		)
		(DrawPic 111)
		(if
			(Print ; "Would you like to restore a previously saved game?"
				155
				2
				#button
				{Restore}
				1
				#button
				{Continue}
				0
				#title
				{Welcome back!}
				#width
				160
				#at
				3
				-1
			)
			(gGame restore:)
		)
		(DisposeScript 993)
		(gCurRoom newRoom: 160)
	)
)

(instance MEMORY_DRV of File
	(properties
		name {MEMORY.DRV}
	)
)

