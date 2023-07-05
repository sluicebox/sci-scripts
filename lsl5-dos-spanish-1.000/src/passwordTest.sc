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
	[local0 50]
	[local50 50]
	local100
)

(procedure (AskPassword &tmp rc)
	(if (not (StrCmp @local50 {NONE}))
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
		(++ local100)
		(proc0_26)
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
		(proc0_27)
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
	(for ((= i 0)) (< i (StrLen @local50)) ((++ i))
		(= seed (- 167 i))
		(= char (^ (StrAt @local50 i) seed))
		(StrAt @local50 i char)
	)
)

(procedure (LoadPassword &tmp [str 30])
	(if (!= (MEMORY_DRV open: 1) 0)
		(MEMORY_DRV readString: @local50 20 read: @str 8 close:)
		(= gPokerJackpot (ReadNumber @str))
	)
	(Hash)
)

(procedure (SavePassword &tmp [str 30])
	(if (!= (MEMORY_DRV open: 2) 0)
		(Hash)
		(Format @str 155 3 gPokerJackpot) ; "%d"
		(MEMORY_DRV
			writeString: @local50
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
		(if (StrCmp @local50 {NONE})
			(= local0 0)
		else
			(StrCpy @local0 @local50)
		)
		(while
			(and
				(< local100 5)
				(or (not (= rc (AskPassword))) (StrCmp @local50 @local0))
			)
		)
		(cond
			((== local100 5)
				(Print ; "I'm sorry, but you have failed to enter the correct password for this game. Please try again when you know the password."
					155
					0
					#title
					{Five Strikes and You're Out!}
				)
				(= gQuit 1)
				(return)
			)
			((== rc 2)
				(proc0_26)
				(GetInput
					@local0
					20
					{Please enter your new password:}
				)
				(proc0_27)
				(ConvertCase)
				(StrCpy @local50 @local0)
				(SavePassword)
				(Printf ; "Your password is now %s. Don't forget it!"
					155
					1
					@local0
					@local0
					80
					{Write this down!}
				)
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

