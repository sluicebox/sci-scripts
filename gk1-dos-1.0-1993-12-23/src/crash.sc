;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1056)
(include sci.sh)
(use Main)
(use interrogation)
(use GKTeller)
(use Array)
(use Talker)
(use Actor)

(public
	crash 0
	wolfgang 1
	tkCrash 2
	tkWolf 3
)

(instance crash of Interrogation
	(properties
		curNoun 5
		sayNoun 4
		verb 127
		modNum 56
		color 9
		index 12
		view 985
		left 226
		top 95
	)

	(method (setPersonals)
		(= personals (IntArray with: 35 36))
		(= personalIndex (IntArray with: 1 2))
	)

	(method (showCases)
		(super showCases: 36 (IsNotInterrogationFlag 280)) ; Drummer
	)

	(method (cue &tmp temp0)
		(switch iconValue
			(36 ; Drummer
				(SetFlag 51)
				(SetInterrogationFlag 280)
				(gEgo getPoints: 177 2)
				(self doVerb:)
			)
			(9 ; Animal Masks
				(= iconValue
					(cond
						((IsInterrogationFlag 280)
							(if (SetInterrogationFlag 282) 54 else 53)
						)
						((SetInterrogationFlag 281) 52)
						(else 51)
					)
				)
				(self sayMessage:)
			)
			(11 ; Damballah
				(= iconValue 55) ; "(SCARED. URGENT WHISPER)No! Don't say that word!  They'll hear you!"
				(if (SetInterrogationFlag 283)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(8 ; Voodoo Hounfour
				(= iconValue
					(cond
						((IsInterrogationFlag 280)
							(gEgo getPoints: 178 1)
							42
						)
						((SetInterrogationFlag 284) 41)
						(else 40)
					)
				)
				(self sayMessage:)
			)
			(42 ; "(RELUCTANT TO GIVE INFO, BUT BLACKMAILED)All right! There's this underground cartel in New Orleans--a Voodoo cartel."
				(SetFlag 74)
				((gCurRoom script:) cue:)
			)
			(5 ; St. John's Eve
				(= iconValue
					(if (IsInterrogationFlag 280)
						(if (SetInterrogationFlag 285) 46 else 45)
					else
						44
					)
				)
				(self sayMessage:)
			)
			(1 ; Voodoo
				(= iconValue
					(cond
						((IsInterrogationFlag 280)
							(if (SetInterrogationFlag 287) 50 else 49)
						)
						((SetInterrogationFlag 286) 38)
						(else 37)
					)
				)
				(self sayMessage:)
			)
			(2 ; Voodoo Murders
				(= iconValue
					(if (IsInterrogationFlag 280)
						(if (SetInterrogationFlag 288) 48 else 47)
					else
						39
					)
				)
				(self sayMessage:)
			)
			(else
				(self doVerb:)
			)
		)
	)
)

(instance wolfgang of Interrogation
	(properties
		curNoun 6
		sayNoun 4
		verb 126
		modNum 56
		color 16
		index 13
		view 984
		left 221
		top 80
	)

	(method (init)
		(if (== gPrevRoomNum 220)
			(= view 9841)
		)
		(super init: &rest)
	)

	(method (setPersonals)
		(= personals (IntArray with: 89 35 58 57 62))
		(= personalIndex (IntArray with: 1 2 3 4 5))
	)

	(method (showCases)
		(super
			showCases:
				89 ; African Homeland
				(and (IsInterrogationFlag 301) (IsNotInterrogationFlag 300))
				58 ; Talisman
				(IsInterrogationFlag 302)
				62 ; Tetelo's Remains
				(IsInterrogationFlag 304)
		)
	)

	(method (cue)
		(switch iconValue
			(89 ; African Homeland
				(SetInterrogationFlag 300)
				(SetFlag 270)
				(gEgo getPoints: 176 3)
				((gCurRoom script:) cue:)
			)
			(9 ; Animal Masks
				(= iconValue 51) ; "Do you know anything about animal masks?"
				(if (SetInterrogationFlag 310)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(13 ; Black Voodoo
				(= iconValue 63) ; "My library contains many books on the occult and religions, and I have read about some particularly evil Voudoun cults..."
				(if (SetInterrogationFlag 311)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(6 ; Cabrit Sans Cor'
				(= iconValue 65) ; "Do you have any idea what cabrit sans cor' means?"
				(if (SetInterrogationFlag 312)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(11 ; Damballah
				(= iconValue 55) ; "Have you ever heard of Damballah?"
				(if (SetInterrogationFlag 313)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(35 ; Himself
				(= iconValue (if (== gDay 9) 68 else 67))
				(self sayMessage:)
			)
			(8 ; Voodoo Hounfour
				(= iconValue
					(cond
						((!= gPrevRoomNum 220) 42)
						((SetInterrogationFlag 315) 41)
						(else 40)
					)
				)
				(self sayMessage:)
			)
			(3 ; New Orleans
				(= iconValue
					(cond
						((!= gPrevRoomNum 220) 79)
						((SetInterrogationFlag 316) 78)
						(else 77)
					)
				)
				(self sayMessage:)
			)
			(12 ; Ogoun Badagris
				(= iconValue 76) ; "Does the name Ogoun Badagris mean anything to you?"
				(if (SetInterrogationFlag 317)
					(= iconValue 80) ; "Do you know anything else about Ogoun Badagris?"
				)
				(self sayMessage:)
			)
			(15 ; Rada Drums
				(= iconValue 81) ; "Rada drums? You mean ceremonial drums?"
				(if (SetInterrogationFlag 318)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(14 ; Schattenj\84ger
				(= iconValue
					(cond
						((!= gPrevRoomNum 220) 86)
						((SetInterrogationFlag 320)
							(if (SetInterrogationFlag 321)
								(if (SetInterrogationFlag 322) 114 else 85)
							else
								84
							)
						)
						(else 83)
					)
				)
				(self sayMessage:)
			)
			(58 ; Talisman
				(= iconValue 60) ; "(SPEAKING OF FAMILY POWER TALISMAN)Let's talk about the talisman."
				(if (SetInterrogationFlag 303)
					(++ iconValue)
					(if (SetInterrogationFlag 304)
						(= iconValue 97) ; "Is there anything else you can tell me about the talisman?"
					)
				)
				(self sayMessage:)
			)
			(57 ; Tetelo
				(= iconValue
					(cond
						((!= gPrevRoomNum 220) 96)
						((SetInterrogationFlag 302)
							(if (SetInterrogationFlag 319) 95 else 94)
						)
						(else 59)
					)
				)
				(self sayMessage:)
			)
			(62 ; Tetelo's Remains
				(= iconValue
					(cond
						((!= gPrevRoomNum 220) 92)
						((SetInterrogationFlag 301)
							(if (SetInterrogationFlag 323) 91 else 98)
						)
						(else 90)
					)
				)
				(self sayMessage:)
			)
			(10 ; V\82v\82
				(= iconValue 99) ; "Do you know anything about v\82v\82s?"
				(if (SetInterrogationFlag 324)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(1 ; Voodoo
				(= iconValue
					(cond
						((!= gPrevRoomNum 220) 49)
						((SetInterrogationFlag 325) 38)
						(else 37)
					)
				)
				(self sayMessage:)
			)
			(else
				(self doVerb:)
			)
		)
	)
)

(instance tkCrash of Talker
	(properties
		x 226
		y 95
		talkWidth 200
		modeless 2
		fore 9
		back 0
		view 985
		textX -231
		textY 2
	)

	(method (init)
		(= font gUserFont)
		(cond
			((IsHiRes)
				(if (< view 10000)
					(+= view 10000)
				)
			)
			((> view 10000)
				(-= view 10000)
			)
		)
		(hisMouth view: view)
		(hisEyes view: view)
		(super init: hisMouth 0 hisEyes &rest)
	)
)

(instance hisMouth of Prop
	(properties
		x 247
		y 133
		view 985
		loop 1
	)
)

(instance hisEyes of Prop
	(properties
		x 243
		y 122
		view 985
		loop 2
	)
)

(instance tkWolf of Talker
	(properties
		x 221
		y 80
		talkWidth 200
		modeless 2
		fore 16
		back 0
		view 984
		textX -231
		textY 1
	)

	(method (init)
		(if (== gPrevRoomNum 220)
			(= view 9841)
			(herMouth view: 9841)
			(herEyes view: 9841)
		)
		(= font gUserFont)
		(cond
			((IsHiRes)
				(if (< view 10000)
					(+= view 10000)
				)
			)
			((> view 10000)
				(-= view 10000)
			)
		)
		(herMouth view: view)
		(herEyes view: view)
		(super init: herMouth 0 herEyes &rest)
	)
)

(instance herMouth of Prop
	(properties
		x 242
		y 119
		view 984
		loop 1
	)
)

(instance herEyes of Prop
	(properties
		x 238
		y 112
		view 984
		loop 2
	)
)

