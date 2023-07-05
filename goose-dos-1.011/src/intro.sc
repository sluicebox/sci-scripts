;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 199)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	intro 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 48] = [51 40 71 75 120 40 135 75 185 40 202 75 251 40 268 75 52 85 69 120 118 85 135 120 178 85 200 120 252 85 267 120 53 130 69 165 118 130 135 165 186 130 202 165 250 130 267 165]
	[local58 88]
	[local146 40]
	[local186 100]
	[local286 12]
)

(procedure (localproc_0 param1 param2)
	(Box posn: param1 param2)
)

(instance intro of Rm
	(properties
		picture 300
		style 0
	)

	(method (init)
		(super init:)
		(if global194
			(= global194 0)
		)
		(Load rsPIC 300)
		(Load rsFONT gSmallFont)
		(Load rsCURSOR gWaitCursor)
		(= global114 0)
		(= global103 0)
		(Load rsVIEW 200)
		(self setScript: introScript)
		(TheMenuBar draw:)
		(SL enable:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance introScript of Script
	(properties)

	(method (handleEvent event &tmp temp0 temp1)
		(switch (event type:)
			(evMOUSERELEASE
				(if local6
					(for ((= temp0 0)) (<= temp0 local4) ((++ temp0))
						(= local3 (* temp0 4))
						(if
							(and
								(> (event x:) [local58 local3])
								(< (event x:) [local58 (+ local3 2)])
								(> (event y:) [local58 (+ local3 1)])
								(< (event y:) [local58 (+ local3 3)])
							)
							(if (!= temp0 local4)
								(= global114 temp0)
								(= local2 temp0)
								(= local8 ([local286 global114] x:))
								(= local9 (+ ([local286 global114] y:) 2))
							else
								(= local2 99)
								(= local8 (NewPlayer x:))
								(= local9 (+ (NewPlayer y:) 2))
							)
							(Box posn: local8 local9)
							(RedrawCast)
							(if (== local2 local1)
								(= cycles 1)
								(break)
							else
								(= local1 local2)
							)
						)
					)
					(event claimed: 1)
				)
			)
			($0040 ; direction
				(= temp0 global114)
				(switch (event message:)
					(JOY_DOWN
						(if (!= local9 153)
							(cond
								((> (+= global114 4) global197)
									(= global114 temp0)
								)
								((== local9 64)
									(localproc_0 local8 (= local9 108))
								)
								((== local9 108)
									(localproc_0 local8 (= local9 153))
								)
							)
						)
					)
					(JOY_UP
						(if (!= local9 64)
							(cond
								((< (-= global114 4) 0)
									(= global114 temp0)
								)
								((== local9 108)
									(localproc_0 local8 (= local9 64))
								)
								((== local9 153)
									(localproc_0 local8 (= local9 108))
								)
							)
						)
					)
					(JOY_RIGHT
						(if (< local8 242)
							(if (> (+= global114 1) global197)
								(= global114 temp0)
							else
								(localproc_0 (+= local8 66) local9)
							)
						)
					)
					(JOY_LEFT
						(if (> local8 62)
							(if (< (-= global114 1) 0)
								(= global114 temp0)
							else
								(localproc_0 (-= local8 66) local9)
							)
						)
					)
				)
			)
		)
		(if (and local6 (== (event message:) KEY_RETURN))
			(event claimed: 1)
			(= cycles 1)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 [temp3 20])
		(switch (= state newState)
			(0
				(HandsOn)
				(if (not global197)
					(gCurRoom newRoom: 200)
				)
				(Display 199 0 dsCOORD 115 10 dsCOLOR 15) ; "K  I  D  S"
				(for ((= local6 0)) (< local6 global197) ((++ local6))
					(= global240 @[global371 (* local6 18)])
					(= temp2 (ReadNumber (+ @[global371 (* local6 18)] 1)))
					(= temp1 2)
					(if (> temp2 9)
						(++ temp1)
					)
					(= global210 (+ @[global371 (* local6 18)] temp1))
					((= [local286 local6] (Prop new:))
						view: 200
						loop: 2
						cel: temp2
						posn:
							(+ 62 (* 66 (mod local6 4)))
							(+ 62 (* 44 (/ local6 4)))
						init:
					)
					(= temp2 (StrLen global210))
					(Display
						global210
						dsWIDTH
						(* temp2 7)
						dsCOORD
						(+ 52 (* 66 (mod local6 4)))
						(+ 65 (* 45 (/ local6 4)))
						dsALIGN
						alLEFT
						dsFONT
						4
						dsCOLOR
						0
					)
				)
				(if (< global197 12)
					(NewPlayer
						posn:
							(+ 62 (* 66 (mod local6 4)))
							(+ 62 (* 44 (/ local6 4)))
						init:
						stopUpd:
					)
					(Display ; "New Player"
						199
						1
						dsWIDTH
						(* (StrLen {New Player}) 7)
						dsCOORD
						(+ 52 (* 66 (mod local6 4)))
						(+ 65 (* 45 (/ local6 4)))
						dsALIGN
						alLEFT
						dsFONT
						4
						dsCOLOR
						0
					)
				)
				(= local8 62)
				(= local9 64)
				(Box init:)
				(for ((= temp0 0)) (< temp0 48) ((++ temp0))
					(= [local58 temp0] [local10 temp0])
				)
				(= local4 global197)
				(= cycles 1)
			)
			(1)
			(2
				(if
					(or
						(not (= global192 [global520 global114]))
						(== local2 99)
					)
					(gCurRoom newRoom: 200)
				else
					(if (not global139)
						(gGame setCursor: gNormalCursor (HaveMouse))
						(= global140 1)
						(DeviceInfo diGET_CURRENT_DEVICE @local146)
						(Format @local186 199 2 @local146) ; "Please insert your SAVE GAME disk in drive %s."
						(DeviceInfo 4) ; CloseDevice
						(if
							(Print
								@local186
								#font
								0
								#button
								{OK}
								0
								#button
								{Change Directory}
								1
							)
							(GetDirectory gCurSaveDir)
						)
					)
					(if (CheckSaveGame (gGame name:) global192 gVersion)
						(gGame restore:)
					else
						(Print 199 3 #font 0 #button {OK} 1) ; "That game was saved under a different interpreter. It cannot be restored."
						(= state 0)
						(= cycles 1)
					)
				)
			)
		)
	)
)

(instance Box of Prop
	(properties
		y 64
		x 62
		view 200
		loop 4
		signal 26624
	)
)

(instance NewPlayer of Prop
	(properties
		view 200
		loop 3
		signal 26624
	)
)

