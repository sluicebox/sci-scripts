;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 307)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use User)
(use Actor)
(use System)

(public
	debugHandler 0
)

(procedure (localproc_0 &tmp temp0)
	(Printf 307 0 (gCurRoom vanishingX:) (gCurRoom vanishingY:)) ; "vanishing x/y=%d/%d"
	(= temp0 (GetNumber {vanishingX:}))
	(or (OneOf temp0 -1 0) (gCurRoom vanishingX: temp0))
	(= temp0 (GetNumber {vanishingY:}))
	(or (OneOf temp0 -1 0) (gCurRoom vanishingY: temp0))
	(Printf 307 0 (gCurRoom vanishingX:) (gCurRoom vanishingY:)) ; "vanishing x/y=%d/%d"
)

(instance debugHandler of Feature
	(properties)

	(method (init)
		(super init:)
		(gFeatures addToFront: self)
		(gIceKeyDownHandler addToFront: self)
		(gIceMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gFeatures delete: self)
		(gIceKeyDownHandler delete: self)
		(gIceMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 101] temp101 temp102 temp103 temp104 temp105 temp106 temp107 [temp108 2] temp110)
		(switch (event type:)
			(evSAID
				(if (Said 'give/*/ego>')
					(if (= temp107 (gInventory saidMe:))
						(Print 307 1) ; "You're the boss..."
						(temp107 moveTo: gEgo)
					else
						(Print 307 2) ; "not in inventory"
					)
					(event claimed: 1)
				)
			)
			(evKEYBOARD
				(= temp105 global59)
				(= global59 iceDebugWindow)
				(event claimed: 1)
				(switch (event message:)
					(KEY_ALT_f
						(gGame showMem:)
					)
					(KEY_ALT_g
						(= temp0 0)
						(GetInput @temp0 4 {Variable No.})
						(= temp102 (ReadNumber @temp0))
						(= temp0 0)
						(GetInput @temp0 4 {Value})
						(= [temp101 (- temp102 100)] (ReadNumber @temp0))
						(= temp0 0)
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_p
						(Show 2)
					)
					(KEY_ALT_c
						(Show 4)
						(Animate (gCast elements:))
						(while (== evNULL ((= event (Event new: 32765)) type:))
							(event dispose:)
						)
						(event dispose:)
						(Show 1)
					)
					(KEY_ALT_a
						(gCast showSelf:)
					)
					(KEY_ALT_t
						(= temp110 (GetNumber {Teleport to:}))
						(= global59 temp105)
						(gCurRoom newRoom: temp110)
					)
					(KEY_ALT_d
						(if (= gDebugOn (not gDebugOn))
							(Print 307 3) ; "Debug On"
						else
							(Print 307 4) ; "Debug Off"
						)
					)
					(KEY_ALT_r
						(Printf 307 5 gCurRoomNum) ; "curRoomNum = %d"
					)
					(KEY_ALT_y
						(localproc_0)
					)
					(KEY_ALT_u
						(UnLoad 130 (GetNumber {Unload Script#:}))
					)
					(else
						(event claimed: 0)
					)
				)
				(= global59 temp105)
			)
			(evMOUSEBUTTON
				(cond
					((& (event modifiers:) emALT)
						(event claimed: 1)
						(= temp103
							(Print
								(Format @temp0 307 6 (event x:) (event y:)) ; "%d/%d"
								#at
								(cond
									((< (event x:) 20)
										(event x:)
									)
									((< 300 (event x:))
										(- (event x:) 40)
									)
									(else
										(- (event x:) 20)
									)
								)
								(if (< (event y:) 16)
									(event y:)
								else
									(- (event y:) 6)
								)
								#font
								999
								#dispose
							)
						)
						(while (!= evMOUSERELEASE ((= temp104 (Event new:)) type:))
							(temp104 dispose:)
						)
						(temp104 dispose:)
						(temp103 dispose:)
					)
					((& (event modifiers:) emCTRL)
						(event claimed: 1)
						(while (!= evMOUSERELEASE ((= temp104 (Event new:)) type:))
							((User alterEgo:)
								posn: (temp104 x:) (- (temp104 y:) 10)
								setMotion: 0
							)
							(Animate (gCast elements:) 0)
							(temp104 dispose:)
						)
						(temp104 dispose:)
					)
				)
			)
		)
	)
)

(instance iceDebugWindow of SysWindow
	(properties
		back 12
	)
)

