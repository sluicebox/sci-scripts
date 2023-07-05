;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1052)
(include sci.sh)
(use Main)
(use interrogation)
(use GKTeller)
(use Array)
(use Talker)
(use Actor)

(public
	bartender 0
	willy 1
	tkBartender 2
	tkWilly 3
)

(instance bartender of Interrogation
	(properties
		curNoun 5
		sayNoun 4
		verb 103
		modNum 52
		color 5
		index 4
		view 978
		left 243
		top 82
	)

	(method (setPersonals)
		(= personals (IntArray with: 35 38 51 39))
		(= personalIndex (IntArray with: 1 2 3 4))
	)

	(method (showCases)
		(super showCases: 51 (and (IsInterrogationFlag 111) (IsInterrogationFlag 113) (IsNotFlag 255))) ; Sam and Voodoo
	)

	(method (cue &tmp temp0 temp1 temp2)
		(switch iconValue
			(6 ; Cabrit Sans Cor'
				(= iconValue 54) ; "You know what goes in it?"
				(if (SetInterrogationFlag 114)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(7 ; Marie Laveau
				(= iconValue 56) ; "Sure. She's kinda the patron saint of Voodoo in New Orleans. Don't know too much about her, but the tourists sure get off on all that stuff."
				(if (SetInterrogationFlag 115)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(3 ; New Orleans
				(= iconValue 58) ; "Greatest city in the world. I'd never want to live anywhere else."
				(if (SetInterrogationFlag 116)
					(++ iconValue)
					(if (SetInterrogationFlag 117)
						(++ iconValue)
						(if (SetInterrogationFlag 118)
							(++ iconValue)
						)
					)
				)
				(self sayMessage:)
			)
			(15 ; Rada Drums
				(= iconValue 62) ; "Rada drums? Are those some special kind?"
				(if (SetInterrogationFlag 119)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(51 ; Sam and Voodoo
				(= iconValue 52) ; "Well, about fifty years ago, Sam was too shy to talk to this pretty girl he was in love with."
				(if (SetInterrogationFlag 120)
					(++ iconValue)
				)
				(gEgo getPoints: 171 1)
				(self sayMessage:)
			)
			(4 ; Snakes
				(= iconValue 64) ; "What about 'em?"
				(if (SetInterrogationFlag 121)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(39 ; Street Musicians
				(= iconValue 48) ; "I like music as much as the next guy, but they get pretty monotonous sometimes, you know?"
				(if (SetInterrogationFlag 122)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(5 ; St. John's Eve
				(= iconValue 66) ; "All I know is, it's some kind of Voodoo holiday."
				(if (SetInterrogationFlag 123)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(2 ; Voodoo Murders
				(= iconValue 68) ; "It's all over the papers. Some kind of serial killings."
				(if (SetInterrogationFlag 124)
					(++ iconValue)
					(if (SetInterrogationFlag 125)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(1 ; Voodoo
				(= iconValue
					(cond
						((SetInterrogationFlag 111)
							(if (IsInterrogationFlag 113)
								(if (SetInterrogationFlag 126) 47 else 37)
							else
								(SetInterrogationFlag 126)
								47
							)
						)
						((IsInterrogationFlag 113)
							(SetInterrogationFlag 126)
							37
						)
						(else 36)
					)
				)
				(self sayMessage:)
			)
			(38 ; Bar Patrons
				(= iconValue
					(if (SetInterrogationFlag 112)
						(cond
							((or (SetInterrogationFlag 113) (IsFlag 255))
								(if (SetInterrogationFlag 127) 45 else 43)
							)
							((IsInterrogationFlag 111) 41)
							(else 42)
						)
					else
						40
					)
				)
				(self sayMessage:)
			)
			(42 ; "See those old guys at the chess table? That's Sam and Markus. They've played there every day for twenty years."
				(= temp2 ((= temp1 (transcript at: curTopic)) size:))
				(temp1 at: (- temp2 1) 90)
				(self doVerb:)
			)
			(41 ; "See those old guys at the chess table? That's Sam and Markus. They've played there every day for twenty years."
				(= temp1 (transcript at: 0))
				(= temp2 curTopic)
				(temp1 at: 0 (+ 1 (temp1 at: 0)))
				(temp1 at: temp2 (+ 1 (temp1 at: temp2)))
				(= temp2 ((= temp1 (transcript at: curTopic)) size:))
				(temp1 at: (- temp2 1) 90 92)
				(self doVerb:)
			)
			(36 ; "Voodoo? Don't believe in it myself. I invented a drink once called Laveau's Tomb, but it wasn't very popular."
				(= temp1 (transcript at: 0))
				(= temp2 curTopic)
				(temp1 at: 0 (+ 1 (temp1 at: 0)))
				(temp1 at: temp2 (+ 1 (temp1 at: temp2)))
				(= temp2 ((= temp1 (transcript at: curTopic)) size:))
				(temp1 at: temp2 91)
				(self doVerb:)
			)
			(37 ; "Voodoo? Don't believe in it myself. I invented a drink once called Laveau's Tomb, but it wasn't very popular."
				(= temp1 (transcript at: 0))
				(= temp2 curTopic)
				(temp1 at: 0 (+ 2 (temp1 at: 0)))
				(temp1 at: temp2 (+ 2 (temp1 at: temp2)))
				(= temp2 ((= temp1 (transcript at: curTopic)) size:))
				(temp1 at: (- temp2 1) 36 91 92)
				(self doVerb:)
			)
			(else
				(self doVerb:)
			)
		)
	)
)

(instance willy of Interrogation
	(properties
		curNoun 6
		sayNoun 4
		verb 102
		modNum 52
		color 11
		index 5
		view 977
		left 225
		top 86
	)

	(method (setPersonals)
		(= personals (IntArray with: 72 35 86))
		(= personalIndex (IntArray with: 1 2 3))
	)

	(method (showCases)
		(super
			showCases:
				72 ; Madame Cazaunoux
				(and (IsFlag 60) (IsNotFlag 266))
				86 ; Willy Jr.
				(and (IsInterrogationFlag 132) (IsNotFlag 358))
		)
	)

	(method (cue)
		(switch iconValue
			(72 ; Madame Cazaunoux
				(= iconValue 73) ; "That customer of yours, the little old lady...."
				(if (SetInterrogationFlag 130)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(35 ; Himself
				(= iconValue 80) ; "My name's Willy Walker. I own the place."
				(if (SetInterrogationFlag 131)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(9 ; Animal Masks
				(= iconValue 75) ; "Do you know anything about animal masks?"
				(if (SetInterrogationFlag 132)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(86 ; Willy Jr.
				(= iconValue 87) ; "About Willy Jr.--would you be willing to let him go?"
				(if (SetInterrogationFlag 144)
					(++ iconValue)
				)
				(if (gEgo has: 30) ; hundred
					(= iconValue 89) ; "(GK-AM2)Are you still interested in selling that crocodile mask?"
				)
				(self sayMessage:)
			)
			(87 ; "About Willy Jr.--would you be willing to let him go?"
				(SetFlag 35)
				(gEgo getPoints: 170 2)
				(self doVerb:)
			)
			(11 ; Damballah
				(= iconValue 82) ; "(LYING)Damballah is an African legend about a 'Great Serpent.' Folklore--that's all."
				(if (SetInterrogationFlag 134)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(7 ; Marie Laveau
				(= iconValue 56) ; "Marie, she's somebody from the old days--one of those folktales. The tourists eat it up, non?"
				(if (SetInterrogationFlag 135)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(3 ; New Orleans
				(= iconValue 58) ; "I've lived here all my life, me."
				(if (SetInterrogationFlag 136)
					(++ iconValue)
					(if (SetInterrogationFlag 137)
						(++ iconValue)
					)
				)
				(self sayMessage:)
			)
			(4 ; Snakes
				(= iconValue 64) ; "What kind of snakes?"
				(if (SetInterrogationFlag 138)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(5 ; St. John's Eve
				(= iconValue 66) ; "It's the biggest night of the year in Voodoo."
				(if (SetInterrogationFlag 139)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(10 ; V\82v\82
				(= iconValue 84) ; "Do you know anything about v\82v\82s?"
				(if (SetInterrogationFlag 140)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(1 ; Voodoo
				(= iconValue
					(if (SetInterrogationFlag 141)
						(if (SetInterrogationFlag 142)
							(if (SetInterrogationFlag 143) 71 else 47)
						else
							37
						)
					else
						36
					)
				)
				(self sayMessage:)
			)
			(2 ; Voodoo Murders
				(= iconValue (if (or (SetInterrogationFlag 145) (SetFlag 42)) 69 else 68))
				(self sayMessage:)
			)
			(68 ; "(RRCC. SAY THIS UNDERBREATH, SUPERSTITIOUSLY/SLIGHTLY FEARFUL)Cabrit sans cor'."
				(gEgo getPoints: -999 2)
				(self doVerb:)
			)
			(6 ; Cabrit Sans Cor'
				(= iconValue 54) ; "(RENUM)What did you mean when you said cabrit sans cor'?"
				(if (IsInterrogationFlag 240)
					(= iconValue 55) ; "(RRCC. SUSPICIOUS)I found out what cabrit sans cor' means. How did YOU know about human sacrifice?"
				)
				(self sayMessage:)
			)
			(else
				(self doVerb:)
			)
		)
	)
)

(instance tkBartender of Talker
	(properties
		x 243
		y 82
		talkWidth 200
		modeless 2
		fore 5
		back 0
		view 978
		textX -228
		textY 3
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
		x 261
		y 119
		view 978
		loop 1
	)
)

(instance hisEyes of Prop
	(properties
		x 262
		y 105
		view 978
		loop 2
	)
)

(instance tkWilly of Talker
	(properties
		x 225
		y 86
		talkWidth 200
		modeless 2
		fore 11
		back 0
		view 977
		textX -230
		textY 3
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
		y 123
		view 977
		loop 1
	)
)

(instance herEyes of Prop
	(properties
		x 244
		y 113
		view 977
		loop 2
	)
)

