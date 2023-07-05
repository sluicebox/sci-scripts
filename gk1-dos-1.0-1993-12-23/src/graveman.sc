;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1054)
(include sci.sh)
(use Main)
(use interrogation)
(use GKTeller)
(use Array)
(use Talker)
(use Actor)

(public
	graveman 0
	moonbeam 1
	tkGrave 2
	tkMoon 3
)

(local
	local0 = -1
	local1 = -1
	local2 = -1
)

(instance graveman of Interrogation
	(properties
		curNoun 5
		sayNoun 4
		verb 112
		modNum 54
		color 15
		index 8
		view 979
		left 221
		top 88
	)

	(method (setPersonals)
		(= personals (IntArray with: 35 39 59))
		(= personalIndex (IntArray with: 1 2 3))
	)

	(method (showCases)
		(super showCases: 39 (IsInterrogationFlag 200)) ; Other Marked Tombs
	)

	(method (cue &tmp temp0)
		(switch iconValue
			(13 ; Black Voodoo
				(= iconValue 45) ; "(RRCC)Black Voodoo? I seen lots of Voodoo markin's in this cemetery. I've seen graves dug up and stuff you don't wanna know about stolen from 'em."
				(if (SetInterrogationFlag 201)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(35 ; Himself
				(= iconValue 42) ; "(RRCC)My name is Toussaint Gervais. I'm the watchman here at St. Louis #1."
				(if (SetInterrogationFlag 202)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(7 ; Marie Laveau
				(= iconValue 36) ; "Do you know anything about Marie Laveau?"
				(if (SetInterrogationFlag 200)
					(++ iconValue)
					(if (SetInterrogationFlag 203)
						(++ iconValue)
					)
				)
				(gEgo getPoints: 166 1)
				(self sayMessage:)
			)
			(3 ; New Orleans
				(= iconValue 47) ; "(RRCC)It seems like everyone wants to visit New Orleans at least once in their lives. And they love the cemetery tours. I see tourists in here every day of the year."
				(if (SetInterrogationFlag 204)
					(++ iconValue)
					(if (SetInterrogationFlag 205)
						(++ iconValue)
						(if (SetInterrogationFlag 206)
							(++ iconValue)
						)
					)
				)
				(self sayMessage:)
			)
			(39 ; Other Marked Tombs
				(= iconValue 40) ; "You said there were other marked tombs?"
				(if (SetInterrogationFlag 207)
					(++ iconValue)
				)
				(gEgo getPoints: 167 1)
				(self sayMessage:)
			)
			(4 ; Snakes
				(= iconValue 51) ; "(RRCC)Snakes? I see snakes around here all the time. Most of them aren't poisonous, 'course."
				(if (SetInterrogationFlag 208)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(5 ; St. John's Eve
				(= iconValue 53) ; "What's the significance of St. John's Eve?"
				(if (SetInterrogationFlag 209)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(59 ; St. Louis Cemetery #1
				(= iconValue 60) ; "(RRCC)You know why the dead are buried in tombs, and not in the ground, doncha? The water table's too high. Them coffins would float right outta their graves!"
				(if (SetInterrogationFlag 210)
					(++ iconValue)
					(if (SetInterrogationFlag 211)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(1 ; Voodoo
				(= iconValue 55) ; "(RRCC)They say it was part of an old religion from Africa, brought here by slaves."
				(if (SetInterrogationFlag 212)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(2 ; Voodoo Murders
				(= iconValue 57) ; "(RRCC)Isn't it just awful, them findin' those bodies with Voodoo things around 'em?"
				(if (SetInterrogationFlag 213)
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

(instance moonbeam of Interrogation
	(properties
		curNoun 6
		sayNoun 4
		verb 111
		modNum 54
		color 10
		index 9
		view 973
		left 239
		top 91
	)

	(method (setPersonals)
		(= personals (IntArray with: 78 63 64))
		(= personalIndex (IntArray with: 1 2 3))
	)

	(method (showCases)
		(super
			showCases:
				78 ; Gris Gris
				(IsInterrogationFlag 215)
				91 ; How did you get into this business?
				(IsNotInterrogationFlag 216)
				94 ; How many Voodooiennes are there?
				(IsNotInterrogationFlag 217)
				93 ; What else do you do?
				(IsNotInterrogationFlag 221)
				92 ; What kind of people come to see you?
				(IsNotInterrogationFlag 220)
				68 ; Would you show me how you handle Grimwald?
				(IsNotInterrogationFlag 218)
				69 ; How about showing me your snake dance again?
				(and (IsInterrogationFlag 218) (not (gEgo has: 37))) ; snakeSkin
				65 ; Where did you get Grimwald?
				(IsNotInterrogationFlag 219)
				67 ; How about giving me one of Grimwald's scales?
				(not (gEgo has: 37)) ; snakeSkin
				66 ; How did you learn how to handle Grimwald?
				(IsNotInterrogationFlag 236)
				64 ; Grimwald
				(IsInterrogationFlag 229)
		)
	)

	(method (cue)
		(switch iconValue
			(92 ; What kind of people come to see you?
				(SetInterrogationFlag 220)
				(self doVerb:)
			)
			(91 ; How did you get into this business?
				(SetInterrogationFlag 216)
				(self doVerb:)
			)
			(94 ; How many Voodooiennes are there?
				(SetInterrogationFlag 217)
				(self doVerb:)
			)
			(93 ; What else do you do?
				(SetInterrogationFlag 221)
				(self doVerb:)
			)
			(65 ; Where did you get Grimwald?
				(SetInterrogationFlag 219)
				(self doVerb:)
			)
			(66 ; How did you learn how to handle Grimwald?
				(SetInterrogationFlag 236)
				(self doVerb:)
			)
			(96 ; I can't think of anything else.
				(self goTop:)
				(self doVerb:)
			)
			(71 ; Nothing, never mind.
				(self goTop:)
				(self doVerb:)
			)
			(67 ; How about giving me one of Grimwald's scales?
				(= iconValue 105) ; "Would you consider giving me one of Grimwald's scales?"
				(if (SetInterrogationFlag 237)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(95 ; Tell me anything at all.
				(= iconValue (+ 97 (mod (++ local0) 5)))
				(self sayMessage:)
			)
			(9 ; Animal Masks
				(= iconValue 86) ; "I saw them used once or twice when I was younger, but you don't see them much anymore. They're too... close."
				(if (SetInterrogationFlag 222)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(68 ; Would you show me how you handle Grimwald?
				(SetInterrogationFlag 218)
				(SetFlag 210)
				((gCurRoom script:) cue:)
			)
			(69 ; How about showing me your snake dance again?
				(SetFlag 210)
				((gCurRoom script:) cue:)
			)
			(70 ; Tell me anything at all.
				(= iconValue (+ 72 (mod (++ local1) 4)))
				(self sayMessage:)
			)
			(13 ; Black Voodoo
				(= iconValue 45) ; "It is the oldest, darkest heart of Voodoo."
				(if (SetInterrogationFlag 223)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(78 ; Gris Gris
				(= iconValue (+ 79 (mod (++ local2) 5)))
				(self sayMessage:)
			)
			(8 ; Voodoo Hounfour
				(= iconValue 89) ; "There are many Voodoo churches in New Orleans, no?"
				(if (SetInterrogationFlag 224)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(7 ; Marie Laveau
				(= iconValue 36) ; "Oh, yes! She was the first of the great Voodoo queens!"
				(if (SetInterrogationFlag 225)
					(++ iconValue)
					(if (SetInterrogationFlag 226)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(3 ; New Orleans
				(= iconValue 47) ; "New Orleans is the center of Voodoo practice in the United States."
				(if (SetInterrogationFlag 227)
					(++ iconValue)
					(if (SetInterrogationFlag 228)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(4 ; Snakes
				(= iconValue 51) ; "Do you know anything about snakes?"
				(if (SetInterrogationFlag 229)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(5 ; St. John's Eve
				(= iconValue 53) ; "St. John's Eve! It is the greatest night of the Voodoo year!"
				(if (SetInterrogationFlag 230)
					(++ iconValue)
					(if (SetInterrogationFlag 231)
						(= iconValue 85) ; "There is no night more powerful to Voodoo magic."
					)
				)
				(gEgo getPoints: 168 2)
				(self sayMessage:)
			)
			(1 ; Voodoo
				(= iconValue
					(if (SetInterrogationFlag 215)
						(if (SetInterrogationFlag 234)
							(if (SetInterrogationFlag 235) 77 else 76)
						else
							56
						)
					else
						55
					)
				)
				(self sayMessage:)
			)
			(2 ; Voodoo Murders
				(= iconValue
					(if (SetInterrogationFlag 232)
						(if (SetInterrogationFlag 233) 84 else 58)
					else
						57
					)
				)
				(self sayMessage:)
			)
			(53 ; "St. John's Eve! It is the greatest night of the Voodoo year!"
				(SetFlag 45)
				(self doVerb:)
			)
			(else
				(self doVerb:)
			)
		)
	)
)

(instance tkGrave of Talker
	(properties
		x 221
		y 88
		talkWidth 200
		modeless 2
		fore 15
		back 0
		view 979
		textX -229
		textY -1
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
		x 240
		y 129
		view 979
		loop 1
	)
)

(instance hisEyes of Prop
	(properties
		x 243
		y 120
		view 979
		loop 2
	)
)

(instance tkMoon of Talker
	(properties
		x 239
		y 91
		talkWidth 200
		modeless 2
		fore 10
		back 0
		view 973
		textX -230
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
		x 259
		y 127
		view 973
		loop 1
	)
)

(instance herEyes of Prop
	(properties
		x 258
		y 116
		view 973
		loop 2
	)
)

