;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 414)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	myCopy 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 48] = [0 36 40 52 0 62 59 85 0 89 37 107 0 116 54 137 0 129 65 161 34 164 107 182 129 164 204 182 219 164 298 182 250 31 303 53 250 60 303 84 250 90 303 118 250 126 303 154]
	[local53 24] = [0 1 5 2 3 4 7 6 8 11 9 10 3 0 7 1 6 5 11 2 4 8 10 9]
	[local77 24] = [10 39 10 68 10 94 10 120 10 143 62 168 159 168 255 168 266 39 266 67 266 97 266 133]
	local101
	local102
	local103
	local104
)

(procedure (localproc_0)
	(SetCursor 1 1 [local77 (* local101 2)] [local77 (+ (* local101 2) 1)])
)

(procedure (localproc_1 param1 param2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 12) ((++ temp0))
		(if
			(and
				(> param1 [local5 (* temp0 4)])
				(> param2 [local5 (+ (* temp0 4) 1)])
				(< param1 [local5 (+ (* temp0 4) 2)])
				(< param2 [local5 (+ (* temp0 4) 3)])
			)
			(return temp0)
		)
	)
	(return 13)
)

(procedure (localproc_2)
	(gCast eachElementDo: #hide)
	(DrawPic 88 4 1 1)
)

(procedure (localproc_3)
	(localproc_2)
	(Print 414 0 #mode 1) ; "Sorry, this performance is sold out. Please come back again."
	(= gQuit 1)
)

(instance Logo of Prop
	(properties)
)

(instance Finger of Prop
	(properties)
)

(instance Glass of Act
	(properties)
)

(instance Mood of Sound ; UNUSED
	(properties)
)

(instance myCopy of Rm
	(properties
		picture 88
		style 8
	)

	(method (init)
		(super init:)
		(TheMenuBar state: 0)
		(= local102 1)
		(gConMusic number: 52 loop: -1 play:)
		(= local0 (/ (Random 0 600) 100))
		(= local1 (/ (Random 1 1000) 250))
		(SetCursor 1 1 320 20)
		(Logo view: 553 loop: 4 cel: 1 posn: 161 120 init: stopUpd:)
		(Finger view: 553 loop: local1 cel: local0 posn: 161 110 init: hide:)
		(Glass
			view: 553
			setLoop: 5
			setCel: 0
			setStep:
				(switch gDetailLevel
					(1 6)
					(else 3)
				)
				3
			posn: 161 140
			init:
		)
		(self setScript: identify)
	)

	(method (newRoom newRoomNumber)
		(gConMusic stop:)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (not local104)
			(if local102
				(switch (event type:)
					(evKEYBOARD
						(cond
							((== (event message:) KEY_RETURN)
								(Logo dispose:)
								(Glass posn: 162 140 setMotion: 0 stopUpd:)
								(Finger show: stopUpd:)
								(identify state: 4 seconds: 0 cycles: 0)
								(self cue:)
							)
							((== (event message:) KEY_F2)
								(= temp0 (DoSound sndSET_SOUND))
								(DoSound sndSET_SOUND (not temp0))
							)
						)
					)
				)
				(event claimed: 1)
				(return)
			)
			(switch (event type:)
				(evJOYDOWN
					(= local104 1)
					(= local102 1)
					(if
						(==
							(= local4 (localproc_1 (event x:) (event y:)))
							[local53 (+ (* local1 6) local0)]
						)
						(self cue:)
					else
						(localproc_3)
					)
					(event claimed: 1)
				)
				(evMOUSEBUTTON
					(= local104 1)
					(= local102 1)
					(if
						(==
							(= local4 (localproc_1 (event x:) (event y:)))
							[local53 (+ (* local1 6) local0)]
						)
						(self cue:)
					else
						(localproc_3)
					)
					(event claimed: 1)
				)
				($0040 ; direction
					(switch (event message:)
						(JOY_UP
							(if (and (!= local101 0) (!= local101 8))
								(if (== local101 7)
									(= local101 11)
								else
									(-- local101)
								)
							)
						)
						(JOY_DOWN
							(if (or (< local101 5) (> local101 7))
								(if (== local101 11)
									(= local101 7)
								else
									(++ local101)
								)
							)
						)
						(JOY_RIGHT
							(if (< local101 7)
								(cond
									((< local101 4)
										(+= local101 8)
									)
									((> local101 4)
										(++ local101)
									)
									(else
										(= local101 11)
									)
								)
							)
						)
						(JOY_LEFT
							(if (> local101 5)
								(if (> local101 7)
									(-= local101 8)
								else
									(-- local101)
								)
							)
						)
					)
					(localproc_0)
					(event claimed: 1)
				)
				(evKEYBOARD
					(cond
						((== (event message:) KEY_RETURN)
							(= local102 1)
							(= local104 1)
							(if
								(==
									(= local4
										(localproc_1 (event x:) (event y:))
									)
									[local53 (+ (* local1 6) local0)]
								)
								(self cue:)
							else
								(localproc_3)
							)
						)
						((== (event message:) KEY_F2)
							(= temp0 (DoSound sndSET_SOUND))
							(DoSound sndSET_SOUND (not temp0))
						)
					)
					(localproc_0)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance identify of Script
	(properties)

	(method (changeState newState &tmp [temp0 25])
		(switch (= state newState)
			(0
				(= local3
					(Display 414 1 dsCOORD 90 16 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0 dsSAVEPIXELS) ; "A SIERRA Production"
				)
				(= cycles 20)
			)
			(1
				(= local2
					(Display
						(Format @temp0 414 2 gVersion) ; "Version %s \04 1989 Sierra On-Line, Inc."
						dsALIGN
						alCENTER
						dsCOORD
						35
						155
						dsWIDTH
						250
						dsCOLOR
						15
						dsBACKGROUND
						-1
						dsFONT
						0
						dsSAVEPIXELS
					)
				)
				(= seconds 4)
			)
			(2
				(if gDetailLevel
					(Glass setMotion: MoveTo 240 140 self)
				else
					(= cycles 1)
				)
			)
			(3
				(Logo dispose:)
				(= cycles 1)
			)
			(4
				(Finger show: stopUpd:)
				(if gDetailLevel
					(Glass setMotion: MoveTo 163 140 self)
				else
					(= cycles 1)
				)
			)
			(5
				(SetCursor 1 1 10 39)
				(= local102 0)
				(Display 414 3 dsRESTOREPIXELS local2)
				(Display 414 3 dsRESTOREPIXELS local3)
				(Display 414 4 dsCOORD 32 8 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 4 dsALIGN alCENTER dsSAVEPIXELS) ; "Using your magnifying glass and the back of the map enclosed in your "Colonel's Bequest" box, please identify the following fingerprint."
				(Display 414 5 dsCOORD 5 40 dsWIDTH 101 dsCOLOR 15 dsBACKGROUND -1 dsFONT 4 dsSAVEPIXELS) ; "Celie  Rudy Dijon  Fifi  Dr. Feels Gertrude Dijon"
				(Display 414 6 dsCOORD 40 170 dsWIDTH 320 dsCOLOR 15 dsBACKGROUND -1 dsFONT 4 dsSAVEPIXELS) ; "Lillian Prune"
				(Display 414 7 dsCOORD 140 170 dsWIDTH 320 dsCOLOR 15 dsBACKGROUND -1 dsFONT 4 dsSAVEPIXELS) ; "Laura Bow"
				(Display 414 8 dsCOORD 230 170 dsWIDTH 320 dsCOLOR 15 dsBACKGROUND -1 dsFONT 4 dsSAVEPIXELS) ; "Ethel Prune"
				(Display 414 9 dsCOORD 255 40 dsWIDTH 101 dsCOLOR 15 dsBACKGROUND -1 dsFONT 4 dsSAVEPIXELS) ; "Jeeves  Col. Dijon  Gloria Swansong  Clarence Sparrow"
			)
			(6
				(= local104 1)
				(= local102 1)
				(localproc_2)
				(Print 414 10 #mode 1) ; "The curtain is about to go up. Please be seated."
				(SetCursor 997 1 300 0)
				(self setScript: (ScriptID 409 0)) ; FirstTimeCk
			)
		)
	)
)

