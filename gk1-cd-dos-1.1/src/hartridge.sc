;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1055)
(include sci.sh)
(use Main)
(use interrogation)
(use GKTeller)
(use Array)
(use Talker)
(use Actor)

(public
	hartridge 0
	cazaunoux 1
	tkHart 2
	tkCaz 3
)

(instance hartridge of Interrogation
	(properties
		curNoun 5
		sayNoun 4
		verb 117
		modNum 55
		color 7
		index 10
		view 981
		left 239
		top 80
	)

	(method (setPersonals)
		(= personals (IntArray with: 35 37))
		(= personalIndex (IntArray with: 1 2))
	)

	(method (showCases)
		(super showCases: 37 (IsInterrogationFlag 240)) ; Human Sacrifice
	)

	(method (cue &tmp temp0)
		(switch iconValue
			(9 ; Animal Masks
				(= iconValue 73) ; "(RUDE)As I said in my lecture, which I assume you actually listened to, is that animal masks--totems--are used extensively in most African Voudoun religions."
				(if (SetInterrogationFlag 241)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(13 ; Black Voodoo
				(= iconValue 76) ; "Tell me what you mean by black Voodoo."
				(if (SetInterrogationFlag 242)
					(++ iconValue)
					(if (SetInterrogationFlag 243)
						(++ iconValue)
						(if (SetInterrogationFlag 244)
							(++ iconValue)
						)
					)
				)
				(self sayMessage:)
			)
			(6 ; Cabrit Sans Cor'
				(= iconValue 36) ; "Do you have any idea what cabrit sans cor' means?"
				(if (SetInterrogationFlag 240)
					(= iconValue 40) ; "(FORGETFUL)What was that translation for cabrit sans cor' again?"
				)
				(gEgo getPoints: 173 1)
				(self sayMessage:)
			)
			(35 ; Himself
				(= iconValue 83) ; "Tell me about yourself."
				(if (SetInterrogationFlag 245)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(8 ; Voodoo Hounfour
				(= iconValue 59) ; "(INTERESTED)Secret Voodoo hounfour? Where, Mr. Knight?"
				(if (SetInterrogationFlag 246)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(37 ; Human Sacrifice
				(= iconValue 38) ; "(LECTURE MODE)It's very rare. Most Voudoun practices do not include human sacrifice as a matter of record, but it IS theoretically possible--if that's what the gods demand."
				(if (SetInterrogationFlag 247)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(7 ; Marie Laveau
				(= iconValue 44) ; "(DISDAINFUL)While I find the colloquial bastardizations of Voudoun somewhat interesting--from a sheerly intellectual point of view--there's not a lot of relation between people like Laveau and true Voudoun practices."
				(if (SetInterrogationFlag 248)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(3 ; New Orleans
				(= iconValue 46) ; "What can you tell me about New Orleans?"
				(if (SetInterrogationFlag 249)
					(++ iconValue)
					(if (SetInterrogationFlag 250)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(15 ; Rada Drums
				(= iconValue 81) ; "(DISDAINFUL)Yes, Rada drums are used in most Voudoun ceremonies."
				(if (SetInterrogationFlag 252)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(5 ; St. John's Eve
				(= iconValue 67) ; "It's June 23rd--the feast day of St. John the Baptist. But June 23rd has been a sacred day since the earliest times."
				(if (SetInterrogationFlag 251)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(10 ; V\82v\82
				(= iconValue (if (IsFlag 227) 87 else 86))
				(self sayMessage:)
			)
			(2 ; Voodoo Murders
				(= iconValue
					(cond
						((IsFlag 227)
							(if (SetInterrogationFlag 254) 72 else 71)
						)
						((SetInterrogationFlag 253) 70)
						(else 69)
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

(instance cazaunoux of Interrogation
	(properties
		curNoun 6
		sayNoun 4
		verb 118
		modNum 55
		color 10
		index 11
		view 982
		left 239
		top 93
	)

	(method (setPersonals)
		(= personals (IntArray with: 61 54 37 41))
		(= personalIndex (IntArray with: 1 2 3 4))
	)

	(method (showCases)
		(super
			showCases:
				52 ; It means "don't eat the chili."
				(IsNotInterrogationFlag 260)
				51 ; It means "that's too bad."
				(and (IsInterrogationFlag 260) (IsNotInterrogationFlag 261))
				50 ; It means "goat without horns."
				(and (IsInterrogationFlag 240) (IsNotInterrogationFlag 262))
				37 ; Human Sacrifice
				(IsInterrogationFlag 262)
				54 ; Real Voodoo Queens
				(IsInterrogationFlag 263)
				61 ; Snake Bracelet
				(and (IsNotFlag 421) (IsFlag 78))
		)
	)

	(method (cue)
		(switch iconValue
			(52 ; It means "don't eat the chili."
				(SetInterrogationFlag 260)
				(self goTop:)
				(self doVerb:)
			)
			(51 ; It means "that's too bad."
				(SetInterrogationFlag 261)
				(self goTop:)
				(self doVerb:)
			)
			(50 ; It means "goat without horns."
				(gEgo getPoints: -999 2)
				(SetInterrogationFlag 262)
				(self goTop:)
				(self doVerb:)
			)
			(49 ; Of course I know what it means. Do you?
				(self goTop:)
				(self doVerb:)
			)
			(41 ; Herself
				(= iconValue 62) ; "(PROUD)Me? I am Creole! My family has been in New Orleans for over two hundred years."
				(if (SetInterrogationFlag 264)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(13 ; Black Voodoo
				(= iconValue 76) ; "(IRISH)Do you know anything about black Voodoo?"
				(if (SetInterrogationFlag 275)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(8 ; Voodoo Hounfour
				(= iconValue 59) ; "(CONSPIRATORY)Well, I've never SEEN it--I wouldn't go near it if you paid me! But it's here in New Orleans, I guarantee it! I hear their drums at night, oh yes! That's why I'm so ill, I tell you--those drums!"
				(if (SetInterrogationFlag 265)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(59 ; "(CONSPIRATORY)Well, I've never SEEN it--I wouldn't go near it if you paid me! But it's here in New Orleans, I guarantee it! I hear their drums at night, oh yes! That's why I'm so ill, I tell you--those drums!"
				(SetFlag 67)
				((gCurRoom script:) cue:)
			)
			(37 ; Human Sacrifice
				(= iconValue 38) ; "(IRISH)Do you know anything about human sacrifice here in New Orleans?"
				(if (SetInterrogationFlag 263)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(7 ; Marie Laveau
				(= iconValue 44) ; "(IRISH)Do you know anything about Marie Laveau?"
				(if (SetInterrogationFlag 266)
					(++ iconValue)
				)
				(if (IsInterrogationFlag 262)
					(= iconValue 88) ; "(IRISH PRIEST BROGUE WITH CAZAUNOUX)Tell me more about Marie Laveau."
				)
				(self sayMessage:)
			)
			(3 ; New Orleans
				(= iconValue 46) ; "(VAIN)The only true New Orleaneans are of French origin, you know."
				(if (SetInterrogationFlag 267)
					(++ iconValue)
					(if (SetInterrogationFlag 268)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(54 ; Real Voodoo Queens
				(SetFlag 44)
				(= iconValue 55) ; "(IRISH. CONSPIRATORY TONE)Who were the REAL Voodoo queens?"
				(if (SetInterrogationFlag 269)
					(++ iconValue)
					(if (SetInterrogationFlag 270)
						(= iconValue 58) ; "(IRISH PRIEST BROGUE WITH CAZAUNOUX)Is there anything else you remember about the real Voodoo queen?"
					)
				)
				(self sayMessage:)
			)
			(4 ; Snakes
				(= iconValue 65) ; "(HORRIFIED--PARANOID SCHIZ HERE)Snakes! They're evil creatures! Did you know that evil people can send them into your dreams? They can! That's why I never sleep."
				(if (SetInterrogationFlag 271)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(61 ; Snake Bracelet
				(SetFlag 67)
				((gCurRoom script:) cue:)
			)
			(5 ; St. John's Eve
				(= iconValue 67) ; "(DELIGHTED)St. John's Eve! Mais oui! I used to love the St. John's Eve mass at St. Louis Cathedral!"
				(if (SetInterrogationFlag 272)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(1 ; Voodoo
				(= iconValue 42) ; "(IRISH)What can you tell me about Voodoo?"
				(if (SetInterrogationFlag 273)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(2 ; Voodoo Murders
				(= iconValue 69) ; "(KNOWINGLY, FED UP)Voodoo Murders! Hah! They are nothing new to me, Father, they happen all the time! I hardly go out anymore--it's too dangerous in the streets."
				(if (SetInterrogationFlag 274)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(53 ; No, I don't.
				(self goTop:)
				(self doVerb:)
			)
			(6 ; Cabrit Sans Cor'
				(= iconValue
					(cond
						((IsInterrogationFlag 262) 85)
						((SetFlag 174) 40)
						(else 36)
					)
				)
				(self sayMessage:)
			)
			(36 ; "(IRISH)Do you have any idea what cabrit sans cor' means?"
				(self newNoun: 7)
				(self doVerb:)
			)
			(40 ; "(IRISH)About cabrit sans cor'...."
				(self newNoun: 7)
				(self doVerb:)
			)
			(else
				(self doVerb:)
			)
		)
	)
)

(instance tkHart of Talker
	(properties
		x 239
		y 80
		talkWidth 200
		modeless 2
		fore 7
		back 0
		view 981
		textX -227
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
		x 256
		y 114
		view 981
		loop 1
	)
)

(instance hisEyes of Prop
	(properties
		x 256
		y 105
		view 981
		loop 2
	)
)

(instance tkCaz of Talker
	(properties
		x 239
		y 93
		talkWidth 200
		modeless 2
		fore 10
		back 0
		view 982
		textX -216
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
		(herMouth view: view)
		(herEyes view: view)
		(super init: herMouth 0 herEyes &rest)
	)
)

(instance herMouth of Prop
	(properties
		x 245
		y 127
		view 982
		loop 1
	)
)

(instance herEyes of Prop
	(properties
		x 243
		y 113
		view 982
		loop 2
	)
)

