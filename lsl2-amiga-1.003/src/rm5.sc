;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Interface)
(use File)
(use Game)
(use User)
(use System)

(public
	rm5 0
)

(instance rm5 of Locale
	(properties)

	(method (handleEvent event &tmp i theObj xyWindow evt fd [string2 50])
		(if (and gDebugging (not (event claimed:)) (== evKEYBOARD (event type:)))
			(switch (event message:)
				(KEY_ALT_i
					(User canInput: 1)
				)
				(KEY_ALT_z
					(= gQuit 1)
				)
				(KEY_ALT_c
					(Show 4)
					(Print 5 0 #at 0 0)
					(Show 1)
				)
				(KEY_ALT_f
					(Print 5 1) ; "Debug will pop up on next newRoom."
					(^= gDebugOn $0001)
				)
				(KEY_ALT_m
					(gGame showMem:)
				)
				(KEY_ALT_p
					(Show 2)
				)
				(KEY_ALT_r
					(Print (Format @gString 5 2 gCurRoomNum)) ; "This is room %d."
				)
				(KEY_ALT_v
					(Show 1)
				)
			)
		)
		(if (and gDebugging (not (event claimed:)) (== evMOUSEBUTTON (event type:)))
			(cond
				((& (event modifiers:) emCTRL)
					(event claimed: 1)
					(User canControl: 1)
					(while (!= evMOUSERELEASE ((= evt (Event new:)) type:))
						(GlobalToLocal evt)
						(gEgo posn: (evt x:) (evt y:) setMotion: 0)
						(RedrawCast)
						(evt dispose:)
					)
					(evt dispose:)
				)
				((& (event modifiers:) emSHIFT)
					(event claimed: 1)
					(= xyWindow
						(Print
							(Format @gString 5 3 (event x:) (event y:)) ; "%d/%d"
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
			)
			(if (event claimed:)
				(return 1)
			)
		)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (and (Said 'pitch>') (= theObj (gInventory saidMe:)))
			(event claimed: 1)
			(if (not (theObj ownedBy: gEgo))
				(Print 5 4) ; "You already pitched it."
			else
				(Print 5 5) ; "Ok, Al."
				(theObj moveTo: -1)
			)
		)
		(if (and (Said 'get>') (= theObj (gInventory saidMe:)))
			(event claimed: 1)
			(if (theObj ownedBy: gEgo)
				(Print 5 6) ; "You already have it, Al."
			else
				(Print 5 5) ; "Ok, Al."
				(theObj moveTo: gEgo)
			)
		)
		(if (Said 'aid')
			(Print 5 7 #font 999) ; "You can now... tp get (name of object) pitch (name of object) make note show timer show ego show grid Alt-C show control Alt-F show fragmenting Alt-I regain typing Alt-M show memory Alt-P show priority Alt-R show room number Alt-V show normal Alt-Z quits Control-click moves ego Shift-click shows mouse location"
		)
		(if (Said 'tp')
			(NormalEgo)
			(gCurRoom newRoom: (GetNumber {Teleport to:}))
		)
		(if (Said 'look/memory')
			(gGame showMem:)
		)
		(if (Said 'look/throw')
			(gCast showSelf:)
		)
		(if (Said 'look/addtopics')
			(gAddToPics showSelf:)
		)
		(if (Said 'look/frag')
			(Print 5 1) ; "Debug will pop up on next newRoom."
			(^= gDebugOn $0001)
		)
		(if (Said 'airport/number')
			(Print (Format @gString 5 2 gCurRoomNum)) ; "This is room %d."
		)
		(if (Said 'make/note')
			(= gString 0)
			(= string2 0)
			(if (GetInput @string2 50 {Writing to "note.log"})
				(Format ; "[r%3d v%3d %3dx/%3dy CS%-5d] Note"
					@gString
					5
					8
					gCurRoomNum
					(gEgo view:)
					(gEgo x:)
					(gEgo y:)
					gCurrentStatus
				)
				(gamefile_sh
					name: {note.log}
					write: @gString @string2 {\0d\n}
					close:
				)
			)
		)
		(if (Said 'look/cord')
			(Print
				(Format ; "%2d:%2d"
					@gString
					5
					9
					(/ gRgTimer 600)
					(/ (mod gRgTimer 600) 10)
				)
			)
		)
		(if (Said 'look/priority')
			(Show 2)
		)
		(if (Said 'look/control')
			(Show 4)
			(Animate (gCast elements:))
			(while (== evNULL ((= event (Event new: $7ffd)) type:)) ; evVERB | evHELP | evMOVE | evJOYUP | evJOYDOWN | evSAID | direction | evMENUHIT | evMENUSTART | evKEYUP | evMOUSEKEYBOARD | $0c00
				(event dispose:)
			)
			(event dispose:)
			(Show 1)
		)
		(if (Said 'look/normal')
			(Show 1)
		)
		(if (Said 'look/ego')
			(Print
				(Format
					@gString
					{view: %d loop: %d cel: %d posn: %d %d pri: %d OnControl: $%x Origin on: $%x}
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
		(if (and (Said 'look/grid') (Load rsPIC 999))
			(DrawPic 999 1 1)
		)
	)
)

