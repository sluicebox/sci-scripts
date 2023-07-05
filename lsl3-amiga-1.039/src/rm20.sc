;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use Interface)
(use File)
(use Game)
(use User)
(use Menu)
(use System)

(public
	rm20 0
)

(instance rm20 of Locale
	(properties)

	(method (handleEvent event &tmp i theObj xyWindow evt [string 30] [string1 30] [string2 30])
		(if (or (not gDebugging) (event claimed:))
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((& (event modifiers:) emSHIFT)
						(event claimed: 1)
						(= xyWindow
							(Print
								(Format @string 20 0 (event x:) (event y:)) ; "%d/%d"
								#at
								150
								100
								#font
								999
								#dispose
							)
						)
						(while (!= evMOUSERELEASE ((= evt (Event new:)) type:))
							(evt dispose:)
						)
						(xyWindow dispose:)
						(evt dispose:)
					)
					((& (event modifiers:) emCTRL)
						(event claimed: 1)
						(User canControl: 1)
						(while (!= evMOUSERELEASE ((= evt (Event new:)) type:))
							(GlobalToLocal evt)
							(gEgo posn: (evt x:) (evt y:) setMotion: 0)
							(Animate (gCast elements:) 0)
							(evt dispose:)
						)
						(evt dispose:)
					)
				)
			)
			(evKEYBOARD
				(switch (event message:)
					(KEY_ALT_c
						(Show 4)
						(Animate (gCast elements:) 0)
						(while (== evNULL ((= event (Event new:)) type:))
							(event dispose:)
						)
						(event dispose:)
						(Show 1)
						(return)
					)
					(KEY_ALT_d
						(SetDebug)
					)
					(KEY_ALT_e
						(if (Load rsVIEW (= i (GetNumber {New Ego View:})))
							(= gNormalEgoView i)
							(NormalEgo)
						)
					)
					(KEY_ALT_f
						(^= gDebugOn $0001)
						(Print
							(Format @string 20 1 (if gDebugOn { } else { NOT })) ; "Debug will%spop up on next newRoom."
						)
					)
					(KEY_ALT_g
						(if (Load rsPIC 999)
							(DrawPic 999 1 1)
						else
							(SetDebug)
						)
					)
					(KEY_ALT_i
						(User canInput: 1)
					)
					(KEY_ALT_m
						(gGame showMem:)
					)
					(KEY_ALT_p
						(Show 2)
					)
					(KEY_ALT_r
						(Print (Format @string 20 2 gCurRoomNum)) ; "You are currently enjoying room %d."
					)
					(KEY_ALT_s
						(if gEgoIsPatti
							(= gEgoIsPatti 0)
							(= gNormalEgoView 700)
							(= gEgoName (Format @gEgoNameBuffer 20 3)) ; "Larry"
						else
							(= gEgoIsPatti 1)
							(= gNormalEgoView 800)
							(= gEgoName (Format @gEgoNameBuffer 20 4)) ; "Patti"
						)
						(NormalEgo)
					)
					(KEY_ALT_t
						(Print
							(Format ; "d:%2d"
								@string
								20
								5
								(/ gRgTimer 600)
								(/ (mod gRgTimer 600) 10)
							)
						)
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_w
						(= string 0)
						(if (!= -1 (GetInput @string 50 {Writing to "ego.log"}))
							(Format @string1 20 6 gCurRoomNum) ; ";[r%3d"
							(Format ; "(ego view %d loop %d cel %d x %d y %d setPri %d)"
								@string2
								20
								7
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
								(gEgo x:)
								(gEgo y:)
								(gEgo priority:)
							)
							(gamefile_sh
								name: {ego.log}
								write: @string1 @string {] } @string2 {\r\n}
								close:
							)
						)
					)
					(KEY_ALT_x
						(= gQuit 1)
					)
					(KEY_ALT_z
						(= gQuit 1)
					)
					(KEY_CAPITAL
						(= i (GetNumber {Teleport to}))
						(if (Load rsSCRIPT i)
							(NormalEgo)
							(gCurRoom newRoom: i)
						else
							(Print 20 8) ; "What room was that supposed to be?"
							(SetDebug)
						)
					)
					(JOY_DOWNRIGHT
						(if gDemo
							(= gDemo 0)
							(TheMenuBar draw:)
							(SL enable:)
							(NormalEgo)
						else
							(= gDemo 1)
							(= i (GetNumber {Teleport to}))
							(if (Load rsSCRIPT i)
								(gCurRoom newRoom: i)
							else
								(SetDebug)
							)
						)
					)
					(JOY_DOWN
						(Print
							(Format
								@string
								{view %d loop %d cel %d posn %d %d pri %d OnControl $%x Origin on $%x}
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
								(gEgo x:)
								(gEgo y:)
								(gEgo priority:)
								(gEgo onControl:)
								(gEgo onControl: 1)
							)
							#icon
							(gEgo view:)
							(gEgo loop:)
							(gEgo cel:)
						)
					)
					(JOY_UPLEFT
						(gGame showMem:)
					)
				)
			)
			(evSAID
				(if (Said 'tp')
					(= i (GetNumber {Teleport to}))
					(if (Load rsSCRIPT i)
						(NormalEgo)
						(gCurRoom newRoom: i)
					else
						(Print 20 8) ; "What room was that supposed to be?"
						(SetDebug)
					)
				)
				(if (and (Said 'pitch>') (= theObj (gInventory saidMe:)))
					(event claimed: 1)
					(if (not (theObj ownedBy: gEgo))
						(Print 20 9) ; "You don't have it, Al."
					else
						(Print 20 10) ; "It's outta here, Al."
						(theObj moveTo: -1)
					)
				)
				(if (and (Said 'get>') (= theObj (gInventory saidMe:)))
					(event claimed: 1)
					(if (theObj ownedBy: gEgo)
						(Print 20 11) ; "You already have it, Al."
					else
						(Print 20 12) ; "You got it, Al."
						(theObj moveTo: gEgo)
					)
				)
			)
		)
		(if (not (event claimed:))
			(super handleEvent: event)
		)
	)
)

