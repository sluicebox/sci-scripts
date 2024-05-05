;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 889)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use User)
(use System)

(public
	rm000Debug 0
)

(procedure (localproc_0 param1 &tmp [temp0 20]) ; UNUSED
	(= temp0 0)
	(if (GetInput @temp0 8 param1)
		(return (ReadNumber @temp0))
	else
		(return -1)
	)
)

(instance rm000Debug of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 255])
		(switch (param1 message:)
			(15872
				(Show 4)
				(Animate (gCast elements:))
				(while (== 0 ((= param1 (Event new: 32765)) type:))
					(param1 dispose:)
				)
				(param1 dispose:)
				(Show 1)
			)
			(16384
				(Show 2)
			)
			(17408
				(Show 1)
			)
			(11776
				(repeat
					(breakif (!= (= temp0 (GetNumber {Clear Flag#: })) -1))
				)
				(ClearFlag temp0)
			)
			(8448
				(gGame showMem:)
			)
			(8704
				(= temp5 0)
				(GetInput @temp5 8 {From Inv. #})
				(= temp2 (ReadNumber @temp5))
				(= temp5 0)
				(GetInput @temp5 8 {To Inv. #})
				(= temp3 (ReadNumber @temp5))
				(for ((= temp0 temp2)) (<= temp0 temp3) ((++ temp0))
					((gInventory at: temp0) moveTo: gEgo)
				)
			)
			(5888
				(= temp1 (Sound pause: 1))
				(= temp5 0)
				(GetInput @temp5 8 {Inv. Object})
				(= temp4 (ReadNumber @temp5))
				(= temp5 0)
				(GetInput @temp5 12 {Owner})
				(if (not (StrCmp {ego} @temp5))
					((gInventory at: temp4) moveTo: gEgo)
				else
					((gInventory at: temp4) moveTo: (ReadNumber @temp5))
				)
				(= temp5 0)
				(Sound pause: temp1)
			)
			(9216
				(Printf 889 0 (DoAudio audPLAY 174)) ; "Playing 174 %d"
			)
			(4864
				(Printf 889 1 gCurRoomNum gCurRoomNum) ; "This is room %d."
			)
			(7936
				(repeat
					(breakif
						(!=
							(= temp0 (GetNumber {Set Flag#: }))
							-1
						)
					)
				)
				(SetFlag temp0)
			)
			(5120
				(User canControl: 1)
				(= gPrevRoomNum 0)
				(proc0_19)
			)
			(4352
				(Unknown_Class_100 doit:)
			)
			(16128
				(if (IsFlag 0)
					(Print 889 2) ; "You cannot save a game right now."
				else
					(gGame save:)
				)
			)
			(16640
				(if (IsFlag 0)
					(Print 889 3) ; "You cannot restore a game right now."
				else
					(gGame restore:)
				)
			)
			(17152
				(= temp1 (Sound pause: 1))
				(if
					(Print ; "Do you wish to start over?"
						889
						4
						#font
						0
						#button
						{__Restart__}
						1
						#button
						{ Continue }
						0
					)
					(gGame restart:)
				)
				(Sound pause: temp1)
			)
			(11520
				(= gQuit 1)
			)
			(11264
				(= gQuit
					(Print ; "Do you really want to quit?"
						889
						5
						#font
						0
						#button
						{____Quit____}
						1
						#button
						{ Continue }
						0
					)
				)
			)
			(else
				(param1 claimed: 0)
			)
		)
	)
)

