;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Language)
(use n940)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm170 0
)

(local
	page
)

(instance rm170 of LLRoom
	(properties
		picture 170
		east 160
	)

	(method (init)
		(self setRegions: 40) ; HollywoodRgn
		(gEgo init: normalize: illegalBits: 8)
		(switch gPrevRoomNum
			(east 0)
			(else
				(HandsOn)
				(gEgo posn: 160 160 edgeHit: EDGE_NONE)
			)
		)
		(super init:)
		(if (not (or (gEgo has: 2) (gEgo has: 3) (gEgo has: 4))) ; A_Blank_Videotape_a, A_Blank_Videotape_b, A_Blank_Videotape_c
			(camcorderTapes init: approachVerbs: 3 stopUpd:) ; Do
		)
		(door init: approachVerbs: 3) ; Do
		(degausser init: approachVerbs: 4) ; Inventory
		(drawer1 init: approachVerbs: 3) ; Do
		(drawer2 init: approachVerbs: 3) ; Do
		(drawer3 init: approachVerbs: 3) ; Do
		(cabinet init:)
		(sterileBarrel init: approachVerbs: 3 4) ; Do, Inventory
		(videoMonitor1 init:)
		(videoMonitor2 init:)
		(drain init:)
		(boxes init:)
		(videotapes1 init:)
		(videotapes2 init:)
		(videotapes3 init:)
		(videotapes4 init:)
		(videotapes5 init:)
		(videotapes6 init:)
		(videotapes7 init:)
		(lightWest init:)
		(lightEast init:)
		(dice init:)
		(eightTrack init: approachVerbs: 3 stopUpd:) ; Do
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 319 116 216 116 204 113 204 108 209 97 198 97 190 101 36 101 11 120 114 120 109 125 60 133 14 129 3 137 3 186 156 164 239 158 242 175 235 189 315 165 315 145 284 143 255 128 283 119 319 119
					yourself:
				)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 170 0) ; "You are so proud of this, your humble workshop."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sOpenDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheMusic2 number: 171 setLoop: 1 play:)
				(gEgo
					view: 171
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(= cycles 3)
			)
			(2
				(switch register
					(3
						(TPrint 170 1 67 -1 150) ; "Nope, nothing of interest in this drawer"
					)
					(2
						(TPrint 170 2 67 -1 150) ; "This drawer only contains a few old donut crumbs"
					)
					(1
						(if (IsFlag 85)
							(TPrint 170 3 67 -1 150) ; "Without the battery recharger, this drawer seems so empty!"
						else
							(TPrint 170 4 67 -1 150) ; "Well, well! What's this? So that's where you left your battery recharger!"
							(Points 8 85)
							(TPrint 170 5 67 -1 150) ; "You take it from the drawer and pop it into your pocket."
							(gEgo get: 1) ; Battery_Charger
						)
					)
				)
				(= cycles 3)
			)
			(3
				(gTheMusic2 number: 171 setLoop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo loop: 3 normalize: illegalBits: 8)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sTapes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 171
					setLoop: 1
					setCel: 0
					posn: 237 158
					setCycle: CT 3 1 self
				)
				(egoBody init:)
			)
			(1
				(camcorderTapes dispose:)
				(gEgo setCycle: End self)
			)
			(2
				(= cycles 5)
			)
			(3
				(Points 6 86)
				(gEgo get: 2 3 4) ; A_Blank_Videotape_a
				(= cycles 5)
			)
			(4
				(gEgo setLoop: 2 posn: 236 184)
				(TPrint 170 6) ; "You always wondered what these tiny little tapes were. These miniature videotapes are a perfect fit for your new camcorder."
				(TPrint 170 7 67 -1 185) ; "(And you thought they were DAT tapes!"
				(egoBody dispose:)
				(gEgo normalize: illegalBits: 8)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sDegaussTape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(if (not register)
					(TPrint 170 8) ; "The tape has already been degaussed."
					(self changeState: 3)
				else
					(gTheMusic2 number: 172 setLoop: -1 play:)
					(Points 2)
					(if (not gTapesDegaussed)
						(TPrint 170 9) ; "Sliding the switch to send rapidly alternating, pulsating currents through your degausser, you sensually slide the girl's dedicated magnetic particles in slow concentric circles over the degausser, gradually increasing in speed and intensity, until they (and you) are randomly aligned. A shudder passes through your body!!"
						(TPrint 170 10 67 -1 185) ; "(By gawd, that's degaussing!"
						(= cycles 1)
					else
						(= ticks 120)
					)
					(if (== (++ gTapesDegaussed) 3)
						(SetFlag 87)
					)
				)
			)
			(2
				(gTheMusic2 stop:)
				(RecordTape 1 register)
				(= cycles 1)
			)
			(3
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 15)
						(+ (gEgo y:) 5)
						self
				)
			)
			(4
				(gEgo setLoop: 2 normalize: illegalBits: 8)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance camcorderTapes of View
	(properties
		x 249
		y 181
		description {the camcorder tapes}
		sightAngle 40
		approachX 236
		approachY 184
		view 170
		priority 15
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 170 11) ; "You've found them! These are the tapes you need for your new Pocket Protector Camcorder"
			)
			(3 ; Do
				(gCurRoom setScript: sTapes)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; Camcorder
						(TPrint 170 12) ; "You try in vain to insert your camcorder into those tiny tapes."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance egoBody of View
	(properties
		x 237
		y 185
		view 171
		loop 2
		priority 10
		signal 16
	)
)

(instance door of Door
	(properties
		x 292
		y 116
		heading 135
		description {the lobby door}
		approachX 240
		approachY 117
		view 171
		loop 3
		entranceTo 160
		moveToX 285
		moveToY 116
		enterType 0
		exitType 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 170 13) ; "The door to the lobby seems oh, so familiar to you. Probably because you entered this room through it! Your "The Girls of Videotape Technician's Magazine" calendar hangs on the back, open to Miss October, who (in your opinion) has the best "reels" of the bunch!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		(gEgo ignoreControl: 8)
		(super init: &rest)
		(self startUpd: setPri: 9)
	)

	(method (open)
		(self setPri: 9)
		(gEgo illegalBits: 0)
		(super open:)
	)

	(method (close)
		(super close:)
		(self setPri: 8)
		(gEgo observeControl: 8 -32768)
	)
)

(instance degausser of Feature
	(properties
		x 162
		y 74
		nsTop 65
		nsLeft 151
		nsBottom 84
		nsRight 173
		description {the degausser}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 170 14) ; "Your degausser, which you use to degauss tapes, rests on the workbench."
			)
			(3 ; Do
				(TPrint 170 15) ; "Degaussers work on tapes, not hands. They return the magnetic particles to a random distribution."
				(TPrint 170 16 67 -1 185) ; "(They erase tapes!"
			)
			(4 ; Inventory
				(if (OneOf invItem 2 3 4) ; A_Blank_Videotape_a, A_Blank_Videotape_b, A_Blank_Videotape_c
					(if ((Inv at: invItem) state:)
						(gCurRoom setScript: sDegaussTape 0 0)
					else
						(gCurRoom setScript: sDegaussTape 0 invItem)
					)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance drawer1 of Feature
	(properties
		x 52
		y 88
		nsTop 84
		nsLeft 37
		nsBottom 93
		nsRight 68
		description {the drawer}
		sightAngle 40
		approachX 57
		approachY 109
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 170 17) ; "It looks like a closed drawer"
			)
			(3 ; Do
				(gCurRoom setScript: sOpenDrawer 0 1)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance drawer2 of Feature
	(properties
		x 99
		y 88
		nsTop 84
		nsLeft 82
		nsBottom 93
		nsRight 117
		description {the drawer}
		sightAngle 40
		approachX 104
		approachY 110
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 170 17) ; "It looks like a closed drawer"
			)
			(3 ; Do
				(gCurRoom setScript: sOpenDrawer 0 2)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance drawer3 of Feature
	(properties
		x 145
		y 88
		nsTop 84
		nsLeft 129
		nsBottom 93
		nsRight 162
		description {the drawer}
		sightAngle 40
		approachX 151
		approachY 110
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 170 17) ; "It looks like a closed drawer"
			)
			(3 ; Do
				(gCurRoom setScript: sOpenDrawer 0 3)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cabinet of Feature
	(properties
		x 98
		y 44
		nsTop 30
		nsLeft 38
		nsBottom 58
		nsRight 159
		description {the cabinet}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 170 18) ; "You have no idea what's inside these cabinets since you are too short to see inside"
			)
			(3 ; Do
				(TPrint 170 19) ; "You've always wanted to use these upper cabinets, but your arms are too short, so you've never seen inside them"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sterileBarrel of Feature
	(properties
		x 222
		y 44
		nsTop 22
		nsLeft 204
		nsBottom 66
		nsRight 240
		description {your barrel of sterilizer}
		sightAngle 40
	)

	(method (doVerb theVerb invItem &tmp [str 250])
		(switch theVerb
			(2 ; Look
				(TPrint 170 20) ; "This barrel contains the sterilizing solution that you use on all incoming video tapes before rewinding them and distributing them to the members of the ASHV Audition Team."
			)
			(3 ; Do
				(Points 1 83)
				(TPrint 170 21) ; "You quickly rinse your hands with the sterilizing solution. You rather enjoy it, although for the life of you, you don't know why."
			)
			(5 ; Talk
				(TPrint 170 22) ; "Hey, Sterilizer!" you yell into the metal drum. "Every night's your night in the barrel!"
			)
			(4 ; Inventory
				(if 1
					(= global200
						(Memory memALLOC_CRIT (StrLen ((Inv at: invItem) description:)))
					)
					(= global203
						(Memory memALLOC_CRIT (StrLen ((Inv at: invItem) description:)))
					)
					(StrSplitInTwo
						global200
						global203
						((Inv at: invItem) description:)
					)
					(Format @str 170 23 global200 37 global203 37) ; "You rinse %s in a stream of sterilizer, effectively removing over 90%c of the bacteria from its environmental surfaces."
					(Memory memFREE global200)
					(Memory memFREE global203)
				)
				(TPrint @str)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance videoMonitor1 of Feature
	(properties
		x 29
		y 68
		nsTop 54
		nsLeft 14
		nsBottom 82
		nsRight 44
		description {the video monitor}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 170 24) ; "You use this monitor every day to preview the incoming submissions, making sure they're explicit enough to pass on to the official members of the Submissions Team."
			)
			(3 ; Do
				(TPrint 170 25) ; "You've seen enough of this monitor over the last few months. You don't want to see any more."
			)
			(4 ; Inventory
				(if (OneOf invItem 2 3 4) ; A_Blank_Videotape_a, A_Blank_Videotape_b, A_Blank_Videotape_c
					(TPrint 170 26) ; "These tapes only fit in your Pocket Protector Camcorder."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance videoMonitor2 of Feature
	(properties
		x 286
		y 168
		nsTop 148
		nsLeft 254
		nsBottom 189
		nsRight 319
		sightAngle 40
	)

	(method (doVerb)
		(videoMonitor1 doVerb: &rest)
	)
)

(instance drain of Feature
	(properties
		x 149
		y 1124
		z 1000
		nsTop 119
		nsLeft 133
		nsBottom 130
		nsRight 166
		description {the floor drain}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 170 27) ; "You often feel this is where your life is headed."
			)
			(3 ; Do
				(TPrint 170 28) ; "Cleverly surmising the humble floor drain is really a secret passage to another part of the building, you yank and tug on the grate, only to find it is firmly screwed."
				(TPrint 170 29 67 -1 185) ; "(You can relate to that!"
			)
			(5 ; Talk
				(TPrint 170 30) ; ""Hello!" you shout down the drain."
				(TPrint 170 31 67 -1 28) ; "Heeeellllooooo."
				(TPrint 170 31) ; "Heeeellllooooo."
				(TPrint 170 31 67 -1 185) ; "Heeeellllooooo."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance boxes of Feature
	(properties
		x 84
		y 156
		nsTop 123
		nsLeft 49
		nsBottom 189
		nsRight 120
		description {the boxes}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 170 32) ; "You have no use for empty boxes."
			)
			(3 ; Do
				(TPrint 170 33) ; "Nah," you think, "who needs a box?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance videotapes1 of Feature
	(properties
		x 10
		y 170
		nsTop 151
		nsBottom 189
		nsRight 21
		description {some videotapes}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 170 34) ; "These tapes are of no use to you."
			)
			(2 ; Look
				(TPrint 170 35) ; "These are the tapes of the women who didn't make the cut. They won't fit in your camcorder."
				(TPrint 170 36 67 -1 185) ; "(And neither do their tapes!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance videotapes2 of Feature
	(properties
		x 116
		y 71
		nsTop 63
		nsLeft 89
		nsBottom 79
		nsRight 143
		sightAngle 40
	)

	(method (doVerb)
		(videotapes1 doVerb: &rest)
	)
)

(instance videotapes3 of Feature
	(properties
		x 55
		y 115
		nsTop 101
		nsLeft 6
		nsBottom 130
		nsRight 104
		sightAngle 40
	)

	(method (doVerb)
		(videotapes1 doVerb: &rest)
	)
)

(instance videotapes4 of Feature
	(properties
		x 169
		y 153
		nsTop 118
		nsLeft 109
		nsBottom 188
		nsRight 229
		sightAngle 40
	)

	(method (doVerb)
		(videotapes1 doVerb: &rest)
	)
)

(instance videotapes5 of Feature
	(properties
		x 227
		y 96
		nsTop 79
		nsLeft 204
		nsBottom 113
		nsRight 250
		sightAngle 40
	)

	(method (doVerb)
		(videotapes1 doVerb: &rest)
	)
)

(instance videotapes6 of Feature
	(properties
		x 304
		y 114
		nsTop 82
		nsLeft 289
		nsBottom 146
		nsRight 319
		sightAngle 40
	)

	(method (doVerb)
		(videotapes1 doVerb: &rest)
	)
)

(instance videotapes7 of Feature
	(properties
		x 103
		y 16
		nsTop 3
		nsLeft 41
		nsBottom 29
		nsRight 166
		sightAngle 40
	)

	(method (doVerb)
		(videotapes1 doVerb: &rest)
	)
)

(instance lightWest of Feature
	(properties
		x 24
		y 32
		nsTop 23
		nsLeft 8
		nsBottom 41
		nsRight 41
		description {the lamp}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 170 37) ; "It's just hanging around here... rather like you, Larry!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (onMe)
		(return (or (super onMe: &rest) (lightEast onMe: &rest)))
	)
)

(instance lightEast of Feature
	(properties
		x 178
		y 29
		nsTop 19
		nsLeft 160
		nsBottom 39
		nsRight 196
		sightAngle 40
	)
)

(instance dice of Feature
	(properties
		x 190
		y 127
		z 52
		nsTop 65
		nsLeft 180
		nsBottom 85
		nsRight 200
		description {the fuzzy dice}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 170 38) ; "Your sole attempt to decorate your work space is one-half of a pair of fuzzy dice, left over from your '74 Bug."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance eightTrack of Prop
	(properties
		x 54
		y 77
		description {your 8-track player}
		sightAngle 40
		approachX 54
		approachY 101
		view 170
		cel 2
	)

	(method (init)
		(= page 0)
		(super init:)
	)

	(method (cue)
		(self doVerb: 3)
	)

	(method (doVerb theVerb &tmp num)
		(switch theVerb
			(2 ; Look
				(TPrint 170 39) ; "Your trusty Strombug Carlton 8-track cartridge tape player rests on your workbench. Although lately you've had trouble finding new cartridges, it still really belts out the tunes."
			)
			(3 ; Do
				(Points 5 84)
				(if (not page)
					(= num
						(PrintD
							{Play which 8-track cartridge?}
							106
							81
							{  The Larry Song  }
							100
							81
							{ Record des Rever }
							640
							106
							81
							{  Desmond's Theme  }
							410
							81
							{  Silas Scruemall  }
							150
							106
							81
							{   Closing Theme   }
							462
							81
							{   Hard Rock Me   }
							500
							106
							81
							{   Hard Rock You  }
							501
							81
							{    Hard Rock It    }
							502
							106
							81
							{  Michelle's Song  }
							535
							81
							{      Shill This      }
							620
							106
							81
							{      Saxy Sex      }
							345
							81
							{On The Boardwalk}
							700
							106
							81
							{< Next Screen >}
							-1
							4
							(LangSwitch 70 79)
							3
							10
							106
							81
							{< Eject >}
							0
							4
							(proc0_28 86 95 90 95 95)
						)
					)
				else
					(= num
						(PrintD
							{Play which 8-track cartridge?}
							106
							81
							{ A Studio Session }
							660
							81
							{  Gettin' Some Air  }
							663
							106
							81
							{    Nasty Girlz     }
							738
							81
							{    Whoz On Top?    }
							740
							106
							81
							{  Tramp's Casino  }
							710
							81
							{    Ivana Skate    }
							790
							106
							81
							{     K-RAP Rap     }
							800
							81
							{     K-RAP Talk     }
							801
							106
							81
							{    K-RAP Rock     }
							802
							81
							{   Doc'll Pulliam    }
							905
							106
							81
							{  Chi Chi a Me Me  }
							910
							81
							{    Salsa This     }
							920
							106
							81
							{< Previous Screen >}
							-1
							4
							(proc0_28 77 70 72 70 70)
							3
							10
							106
							81
							{< Eject >}
							0
							4
							(proc0_28 85 95 90 95 95)
						)
					)
				)
				(switch num
					(-1
						(= page (- 1 page))
						(Delay 1 0 self)
					)
					(0
						(gTheMusic number: 160 setLoop: -1 play:)
					)
					(else
						(gTheMusic number: num setLoop: -1 play:)
					)
				)
				(if
					(and
						(== (gEgo x:) approachX)
						(== (gEgo y:) approachY)
					)
					(gEgo
						setMotion: MoveTo (+ (gEgo x:) 15) (+ (gEgo y:) 5)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance funSound of Sound ; UNUSED
	(properties)
)

