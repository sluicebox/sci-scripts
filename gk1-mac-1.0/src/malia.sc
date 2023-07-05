;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1053)
(include sci.sh)
(use Main)
(use interrogation)
(use GKTeller)
(use Array)
(use Talker)
(use Actor)

(public
	malia 0
	drJohn 1
	tkMalia 2
	tkDrJohn 3
)

(local
	local0 = -1
	local1 = -1
	local2 = -1
)

(instance malia of Interrogation
	(properties
		curNoun 5
		sayNoun 4
		verb 110
		modNum 53
		color 6
		index 6
		view 980
		left 221
		top 93
	)

	(method (setPersonals)
		(= personals (IntArray with: 38 36 37))
		(= personalIndex (IntArray with: 1 2 3))
	)

	(method (showCases)
		(super
			showCases:
				37 ; Lake Pontchartrain
				(== gPrevRoomNum 360)
				58 ; Do you have a husband? Boyfriend?
				(IsNotInterrogationFlag 161)
				16 ; What kinds of things interest you?
				(IsNotInterrogationFlag 160)
				57 ; Tell me about your family.
				(IsNotInterrogationFlag 159)
				56 ; Do you have a career?
				(IsNotInterrogationFlag 158)
		)
	)

	(method (cue &tmp temp0)
		(switch iconValue
			(36 ; Herself
				(= iconValue 54) ; "I suppose I don't really have a choice. What do you want to know, Detective?"
				(if (SetInterrogationFlag 150)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(60 ; I wouldn't know where to begin.
				(self goTop:)
				(self doVerb:)
			)
			(38 ; Flirt With Her
				(= iconValue (+ 42 (mod (++ local0) 5)))
				(if (> local0 4)
					(= iconValue 128) ; "Are you sure you won't go out with me? I promise I'll be good."
				)
				(self sayMessage:)
			)
			(42 ; "(FLIRTING)Excuse me, but...your eyes are really distracting. I don't think I've ever seen a color quite like that brownish-gold. It's so deep and rich. Man, if I could bottle that, I'd make a fortune."
				(if
					(and
						(IsInterrogationFlag 152)
						(IsInterrogationFlag 151)
						(>= local0 0)
						(IsNotFlag 264)
					)
					(SetFlag 264)
					(= iconValue 66) ; "I think this has gone on long enough. You're not really a detective, are you?"
					(self sayMessage:)
				else
					(self doVerb:)
				)
			)
			(37 ; Lake Pontchartrain
				(SetInterrogationFlag 151)
				(if
					(and
						(IsInterrogationFlag 152)
						(IsInterrogationFlag 151)
						(>= local0 0)
						(IsNotFlag 264)
					)
					(SetFlag 264)
					(= iconValue 66) ; "I think this has gone on long enough. You're not really a detective, are you?"
					(self sayMessage:)
				else
					(self doVerb:)
				)
			)
			(40 ; "Are you sure you can't tell me anything about Voodoo?"
				(if
					(and
						(IsInterrogationFlag 152)
						(IsInterrogationFlag 151)
						(>= local0 0)
						(IsNotFlag 264)
					)
					(SetFlag 264)
					(= iconValue 66) ; "I think this has gone on long enough. You're not really a detective, are you?"
					(self sayMessage:)
				else
					(self doVerb:)
				)
			)
			(39 ; "What can you tell me about Voodoo?"
				(if
					(and
						(IsInterrogationFlag 152)
						(IsInterrogationFlag 151)
						(>= local0 0)
						(IsNotFlag 264)
					)
					(SetFlag 264)
					(= iconValue 66) ; "I think this has gone on long enough. You're not really a detective, are you?"
					(self sayMessage:)
				else
					(self doVerb:)
				)
			)
			(66 ; "I think this has gone on long enough. You're not really a detective, are you?"
				((gCurRoom script:) cue:)
			)
			(3 ; New Orleans
				(= iconValue 47) ; "Tell me about your life in New Orleans."
				(if (SetInterrogationFlag 154)
					(++ iconValue)
					(if (SetInterrogationFlag 155)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(59 ; I'd like to hear just about anything.
				(= iconValue (+ 61 (mod (++ local1) 5)))
				(self sayMessage:)
			)
			(2 ; Voodoo Murders
				(= iconValue 51) ; "The murders? Only what I read in the papers."
				(if (SetInterrogationFlag 156)
					(++ iconValue)
					(if (SetInterrogationFlag 157)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(1 ; Voodoo
				(= iconValue 39) ; "What can you tell me about Voodoo?"
				(if (SetInterrogationFlag 152)
					(++ iconValue)
					(if (SetInterrogationFlag 153)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(58 ; Do you have a husband? Boyfriend?
				(SetInterrogationFlag 161)
				(self doVerb:)
			)
			(16 ; What kinds of things interest you?
				(SetInterrogationFlag 160)
				(self doVerb:)
			)
			(57 ; Tell me about your family.
				(SetInterrogationFlag 159)
				(self doVerb:)
			)
			(56 ; Do you have a career?
				(SetInterrogationFlag 158)
				(self doVerb:)
			)
			(else
				(self doVerb:)
			)
		)
	)
)

(instance drJohn of Interrogation
	(properties
		curNoun 7
		sayNoun 4
		verb 109
		modNum 53
		color 13
		index 7
		view 975
		left 239
		top 94
	)

	(method (setPersonals)
		(= personals (IntArray with: 70 35 69 114 71))
		(= personalIndex (IntArray with: 1 2 3 4 5))
	)

	(method (showCases)
		(super
			showCases:
				93 ; Why did you open a Voodoo museum?
				(IsNotInterrogationFlag 166)
				94 ; What kind of background in Voodoo do you have?
				(IsNotInterrogationFlag 167)
				95 ; Do you do anything besides run the museum?
				(IsNotInterrogationFlag 168)
				96 ; What are your own religious beliefs?
				(IsNotInterrogationFlag 169)
				71 ; Malia Gedde
				(IsInterrogationFlag 152)
				70 ; Current Voodoo
				(IsInterrogationFlag 176)
				69 ; Historical Voodoo
				(IsInterrogationFlag 176)
				114 ; Hoodoo
				(IsInterrogationFlag 172)
		)
	)

	(method (cue)
		(switch iconValue
			(93 ; Why did you open a Voodoo museum?
				(SetInterrogationFlag 166)
				(self doVerb:)
			)
			(94 ; What kind of background in Voodoo do you have?
				(SetInterrogationFlag 167)
				(self doVerb:)
			)
			(95 ; Do you do anything besides run the museum?
				(SetInterrogationFlag 168)
				(self doVerb:)
			)
			(96 ; What are your own religious beliefs?
				(SetInterrogationFlag 169)
				(self doVerb:)
			)
			(9 ; Animal Masks
				(= iconValue 104) ; "Do you know anything about animal masks?"
				(if (SetInterrogationFlag 170)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(13 ; Black Voodoo
				(= iconValue 67) ; "Do you know anything about black Voodoo?"
				(if (SetInterrogationFlag 171)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(70 ; Current Voodoo
				(= iconValue 72) ; "Tell me about current Voodoo."
				(if (SetInterrogationFlag 172)
					(++ iconValue)
					(if (SetInterrogationFlag 173)
						(= iconValue 76) ; "Tell me more about current Voodoo."
						(SetInterrogationFlag 174)
						(SetInterrogationFlag 175)
					)
				)
				(self sayMessage:)
			)
			(73 ; "Tell me more about current Voodoo."
				(SetFlag 267)
				(gEgo getPoints: 162 2)
				(self doVerb:)
			)
			(69 ; Historical Voodoo
				(= iconValue 77) ; "Tell me about historical Voodoo."
				(if (SetInterrogationFlag 178)
					(++ iconValue)
					(if (SetInterrogationFlag 179)
						(++ iconValue)
						(if (SetInterrogationFlag 180)
							(++ iconValue)
							(if (SetInterrogationFlag 181)
								(++ iconValue)
								(if (SetInterrogationFlag 18)
									(= iconValue 123) ; "Tell me more about historical Voodoo."
								)
							)
						)
					)
				)
				(self sayMessage:)
			)
			(81 ; "Tell me more about historical Voodoo."
				(SetFlag 43)
				(gEgo getPoints: 163 2)
				(self doVerb:)
			)
			(35 ; Himself
				(= iconValue 91) ; "Me?"
				(if (SetInterrogationFlag 177)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(98 ; Actually, I can't think of a thing.
				(self goTop:)
				(self doVerb:)
			)
			(97 ; Just tell me anything.
				(= iconValue (+ 99 (mod (++ local2) 5)))
				(self sayMessage:)
			)
			(7 ; Marie Laveau
				(= iconValue 84) ; "There were actually two Marie Laveaus--mother and daughter. Most people thought they were the same woman. Her 'continued youth' added to the mystique."
				(if (SetInterrogationFlag 182)
					(++ iconValue)
					(if (SetInterrogationFlag 183)
						(++ iconValue)
						(if (SetInterrogationFlag 184)
							(++ iconValue)
							(if (SetInterrogationFlag 185)
								(++ iconValue)
								(if (SetInterrogationFlag 186)
									(++ iconValue)
									(if (SetInterrogationFlag 187)
										(++ iconValue)
									)
								)
							)
						)
					)
				)
				(self sayMessage:)
			)
			(89 ; "The Laveau tomb--where one or both of the Maries are believed to be buried--is in St. Louis Cemetery #1."
				(SetFlag 77)
				(gEgo getPoints: 164 2)
				(self doVerb:)
			)
			(71 ; Malia Gedde
				(= iconValue 82) ; "Do you know Malia Gedde?"
				(if (SetInterrogationFlag 188)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(3 ; New Orleans
				(= iconValue 47) ; "What do you think of New Orleans?"
				(if (SetInterrogationFlag 189)
					(++ iconValue)
					(if (SetInterrogationFlag 190)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(4 ; Snakes
				(= iconValue 106) ; "Do you know anything about snakes?"
				(if (SetInterrogationFlag 191)
					(++ iconValue)
					(if (SetInterrogationFlag 192)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(5 ; St. John's Eve
				(= iconValue 109) ; "What can you tell me about St. John's Eve?"
				(if (SetInterrogationFlag 193)
					(++ iconValue)
					(if (SetInterrogationFlag 194)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(2 ; Voodoo Murders
				(= iconValue 51) ; "What do you know about the Voodoo Murders?"
				(if (SetInterrogationFlag 195)
					(++ iconValue)
					(if (SetInterrogationFlag 196)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(1 ; Voodoo
				(SetInterrogationFlag 176)
				(self doVerb:)
			)
			(6 ; Cabrit Sans Cor'
				(= iconValue 112) ; "Do you have any idea what cabrit sans cor' means?"
				(if (SetInterrogationFlag 197)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(11 ; Damballah
				(= iconValue 115) ; "Have you ever heard of Damballah?"
				(if (SetInterrogationFlag 198)
					(++ iconValue)
					(if (SetInterrogationFlag 199)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(114 ; Hoodoo
				(= iconValue 119) ; "What, exactly, is Hoodoo?"
				(if (SetInterrogationFlag 19)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(12 ; Ogoun Badagris
				(= iconValue 124) ; "Does the name Ogoun Badagris mean anything to you?"
				(if (SetInterrogationFlag 20)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(else
				(self doVerb:)
			)
		)
	)
)

(instance tkDrJohn of Talker
	(properties
		x 239
		y 94
		talkWidth 200
		modeless 2
		fore 13
		back 0
		view 975
		textX -221
		textY 6
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
		x 250
		y 128
		view 975
		loop 1
	)
)

(instance hisEyes of Prop
	(properties
		x 247
		y 117
		view 975
		loop 2
	)
)

(instance tkMalia of Talker
	(properties
		x 221
		y 93
		talkWidth 200
		modeless 2
		fore 6
		back 0
		view 980
		textX -233
		textY 4
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
		(herMouth view: view)
		(herEyes view: view)
		(super init: herMouth 0 herEyes &rest)
	)
)

(instance herMouth of Prop
	(properties
		x 244
		y 129
		view 980
		loop 1
	)
)

(instance herEyes of Prop
	(properties
		x 241
		y 119
		view 980
		loop 2
	)
)

