;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1051)
(include sci.sh)
(use Main)
(use interrogation)
(use GKTeller)
(use Array)
(use Talker)
(use Actor)

(public
	mosely 0
	granny 1
	tkMose 2
	tkGran 3
)

(local
	local0 = -1
	local1 = -1
	local2 = -1
	local3 = -1
	local4 = -1
	local5 = -1
	local6 = -1
)

(instance mosely of Interrogation
	(properties
		curNoun 5
		sayNoun 4
		verb 82
		modNum 51
		color 4
		index 2
		view 974
		left 236
		top 84
	)

	(method (init)
		(if (IsFlag 99)
			(= view 9741)
		)
		(super init: &rest)
		(return self)
	)

	(method (setPersonals)
		(= personals
			(IntArray with: 37 41 153 150 145 42 35 61 40 39 38 148 43 149 36)
		)
		(= personalIndex (IntArray with: 0 1 2 2 3 4 5 6 7 7 8 9 10 9 11))
	)

	(method (showCases)
		(super
			showCases:
				37 ; Coffee
				(and (== gPrevRoomNum 240) (IsNotFlag 4))
				41 ; Crash's Death
				(and (IsFlag 74) (IsNotInterrogationFlag 43) (< gDay 10))
				153 ; Fill Him In
				(and (IsNotInterrogationFlag 44) (== gDay 10))
				150 ; Fill Me In
				(and (IsNotInterrogationFlag 45) (== gDay 10))
				145 ; Grace
				(== gDay 10)
				42 ; Hartridge's Death
				(and (IsFlag 224) (IsNotInterrogationFlag 47) (< gDay 10))
				39 ; Pattern Around Bodies
				(and (IsFlag 110) (IsNotInterrogationFlag 49))
				40 ; Other Six Patterns
				(and (IsInterrogationFlag 49) (IsNotFlag 75))
				38 ; Photographs
				(and (IsFlag 61) (IsNotFlag 2) (IsNotFlag 3))
				148 ; Make a Plan
				(and (== gDay 10) (IsNotInterrogationFlag 51))
				149 ; Repeat Plan
				(IsInterrogationFlag 51)
				36 ; Case Status
				(< gDay 6)
				43 ; Reopen Case
				(and (IsNotFlag 16) (IsFlag 22))
				56 ; What are your plans for the future?
				(IsNotInterrogationFlag 56)
				51 ; How do you like working on the police force?
				(IsNotInterrogationFlag 57)
				57 ; Got any hobbies?
				(IsNotInterrogationFlag 58)
				58 ; How's your home life?
				(IsNotInterrogationFlag 59)
				82 ; How many murders have there been so far?
				(IsNotInterrogationFlag 60)
				81 ; Do you know anything about the killers?
				(IsNotInterrogationFlag 61)
				84 ; Describe the crime scenes.
				(IsNotInterrogationFlag 62)
				87 ; Know anything about the victims?
				(IsNotInterrogationFlag 63)
				85 ; What does the coroner say?
				(IsNotInterrogationFlag 69)
				83 ; What kind of evidence have you found?
				(IsNotInterrogationFlag 70)
				86 ; Any witnesses?
				(IsNotInterrogationFlag 64)
				92 ; A cop/author photo might be nice.
				(IsNotInterrogationFlag 65)
				91 ; Let's take another cop/author shot.
				(IsInterrogationFlag 65)
		)
	)

	(method (cue &tmp temp0 temp1 temp2)
		(switch iconValue
			(37 ; Coffee
				(= iconValue
					(if (SetInterrogationFlag 41)
						(if (SetInterrogationFlag 42) 96 else 95)
					else
						94
					)
				)
				(SetFlag (if (== iconValue 94) 17 else 18)) ; "Coffee? You want coffee?"
				(self sayMessage:)
			)
			(94 ; "Coffee? You want coffee?"
				(gEgo getPoints: 156 1)
				(gCurRoom cue:)
			)
			(95 ; "What am I, your slave?"
				(gCurRoom cue:)
			)
			(96 ; "No way! Enough is enough!"
				(gCurRoom cue:)
			)
			(41 ; Crash's Death
				(= iconValue 100) ; "What? What're you talkin' about? I just let him go this morning."
				(if (== gDay 5)
					(++ iconValue)
				)
				(SetInterrogationFlag 43)
				(SetFlag 415)
				(self sayMessage:)
			)
			(101 ; "What? What are you talkin' about? I let him go yesterday."
				(= temp1 (transcript at: 0))
				(= temp2 curTopic)
				(temp1 at: 0 (+ 1 (temp1 at: 0)))
				(temp1 at: temp2 (+ 1 (temp1 at: temp2)))
				(= temp2 ((= temp1 (transcript at: curTopic)) size:))
				(temp1 at: temp2 102)
				(self doVerb:)
			)
			(100 ; "What? What're you talkin' about? I just let him go this morning."
				(= temp1 (transcript at: 0))
				(= temp2 curTopic)
				(temp1 at: 0 (+ 1 (temp1 at: 0)))
				(temp1 at: temp2 (+ 1 (temp1 at: temp2)))
				(= temp2 ((= temp1 (transcript at: curTopic)) size:))
				(temp1 at: temp2 102)
				(self doVerb:)
			)
			(153 ; Fill Him In
				(= iconValue 154) ; "Okay. Have at it."
				(SetInterrogationFlag 44)
				(self sayMessage:)
			)
			(150 ; Fill Me In
				(= iconValue 151) ; "So, fill me in on what you've been doing for the past five days."
				(SetInterrogationFlag 45)
				(self sayMessage:)
			)
			(145 ; Grace
				(= iconValue 146) ; "Them Voodoo people have taken her, the goddamn bastards! We have to find her and save her, and we can't count on the police department for any help."
				(if (SetInterrogationFlag 46)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(42 ; Hartridge's Death
				(= iconValue 129) ; "What? What're you talkin' about?"
				(if (IsInterrogationFlag 43)
					(-- iconValue)
				)
				(SetInterrogationFlag 47)
				(self sayMessage:)
			)
			(128 ; "Oh, Christ! You're not gonna to start this again!"
				(= temp1 (transcript at: 0))
				(= temp2 curTopic)
				(temp1 at: 0 (+ 1 (temp1 at: 0)))
				(temp1 at: temp2 (+ 1 (temp1 at: temp2)))
				(= temp2 ((= temp1 (transcript at: curTopic)) size:))
				(temp1 at: temp2 219)
				(self doVerb:)
			)
			(129 ; "What? What're you talkin' about?"
				(= temp1 (transcript at: 0))
				(= temp2 curTopic)
				(temp1 at: 0 (+ 1 (temp1 at: 0)))
				(temp1 at: temp2 (+ 1 (temp1 at: temp2)))
				(= temp2 ((= temp1 (transcript at: curTopic)) size:))
				(temp1 at: temp2 219)
				(self doVerb:)
			)
			(35 ; Himself
				(= iconValue 130) ; "For the book?"
				(if (SetInterrogationFlag 48)
					(++ iconValue)
				)
				(if (> gDay 3)
					(self goTop:)
					(= iconValue 217) ; "(RRCC. GABE ASKED ABOUT 'HIMSELF')Whaddaya wanna talk about that for now? We're not doing the book anymore. Besides, you already know too much about me, Knight!"
				)
				(if (== gDay 10)
					(self goTop:)
					(= iconValue 132) ; "I'm scared shitless! That's all you need to know!"
				)
				(self sayMessage:)
			)
			(61 ; Insult Him
				(= iconValue (+ 62 (mod (++ local6) 6)))
				(if (== gDay 10)
					(= iconValue 216) ; "You know, Mostly...."
				)
				(self sayMessage:)
			)
			(38 ; Photographs
				(= iconValue 89) ; "Really? Great! What'd ya think?"
				(if (SetInterrogationFlag 50)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(36 ; Case Status
				(= iconValue
					(cond
						((< gDay 3)
							(if (SetInterrogationFlag 52) 124 else 123)
						)
						((== gDay 3)
							(if (SetInterrogationFlag 53) 134 else 98)
						)
						((SetInterrogationFlag 54) 133)
						(else 99)
					)
				)
				(self sayMessage:)
			)
			(99 ; "(RRCC. ADAMANT)The case? What case? I TOLD you, the Voodoo Murders case is CLOSED!"
				(SetFlag 22)
				(self doVerb:)
			)
			(43 ; Reopen Case
				(SetFlag 331)
				(= temp0 0)
				(if (IsFlag 26)
					(++ temp0)
				)
				(if (IsFlag 33)
					(+= temp0 2)
				)
				(if (IsFlag 241)
					(+= temp0 4)
				)
				(= iconValue
					(switch temp0
						(0
							(if (SetInterrogationFlag 55) 136 else 135)
						)
						(1 138)
						(2 158)
						(3 144)
						(4 159)
						(5 156)
						(6 157)
						(else -1)
					)
				)
				(self sayMessage:)
			)
			(59 ; Just tell me anything at all.
				(= iconValue (+ 68 (mod (++ local5) 6)))
				(self sayMessage:)
			)
			(56 ; What are your plans for the future?
				(SetInterrogationFlag 56)
				(self doVerb:)
			)
			(51 ; How do you like working on the police force?
				(SetInterrogationFlag 57)
				(self doVerb:)
			)
			(57 ; Got any hobbies?
				(SetInterrogationFlag 58)
				(self doVerb:)
			)
			(58 ; How's your home life?
				(SetInterrogationFlag 59)
				(self doVerb:)
			)
			(60 ; Oh, nothing. Never mind.
				(self goTop:)
				(self doVerb:)
			)
			(82 ; How many murders have there been so far?
				(SetInterrogationFlag 60)
				(self doVerb:)
			)
			(81 ; Do you know anything about the killers?
				(SetInterrogationFlag 61)
				(self doVerb:)
			)
			(84 ; Describe the crime scenes.
				(SetInterrogationFlag 62)
				(self doVerb:)
			)
			(87 ; Know anything about the victims?
				(SetInterrogationFlag 63)
				(self doVerb:)
			)
			(86 ; Any witnesses?
				(SetInterrogationFlag 64)
				(self doVerb:)
			)
			(85 ; What does the coroner say?
				(SetInterrogationFlag 69)
				(self doVerb:)
			)
			(83 ; What kind of evidence have you found?
				(SetInterrogationFlag 70)
				(self doVerb:)
			)
			(88 ; Oh, nothing. Never mind.
				(self goTop:)
				(self doVerb:)
			)
			(92 ; A cop/author photo might be nice.
				(SetInterrogationFlag 65)
				(SetFlag 19)
				(gEgo getPoints: 155 2)
				(gCurRoom cue:)
			)
			(91 ; Let's take another cop/author shot.
				(SetFlag 19)
				(gCurRoom cue:)
			)
			(93 ; Nope. I think we have everything we need.
				(self goTop:)
				(self doVerb:)
			)
			(8 ; Voodoo Hounfour
				(= iconValue
					(cond
						((== gDay 10)
							(if (SetInterrogationFlag 67) 106 else 105)
						)
						((SetInterrogationFlag 66) 104)
						(else 103)
					)
				)
				(self sayMessage:)
			)
			(7 ; Marie Laveau
				(= iconValue 107) ; "Is she that red-headed chick that works at Freddy's?"
				(if (SetInterrogationFlag 68)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(3 ; New Orleans
				(= iconValue 109) ; "(ARCC)You and me grew up together, you tell me!"
				(if (SetInterrogationFlag 71)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(12 ; Ogoun Badagris
				(= iconValue 111) ; "Say WHAT?"
				(if (SetInterrogationFlag 72)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(15 ; Rada Drums
				(= iconValue 113) ; "No."
				(if (SetInterrogationFlag 73)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(14 ; Schattenj\84ger
				(= iconValue 115) ; "(CRACKING HIMSELF UP)No, hah! Is that anything like a Chuck Yaeger?"
				(if (SetInterrogationFlag 74)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(4 ; Snakes
				(= iconValue 117) ; "(RRCC. DISGUSTED)The only thing I know about snakes is that I don't like 'em."
				(if (SetInterrogationFlag 75)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(5 ; St. John's Eve
				(= iconValue 119) ; "That's comin' up, isn't it?"
				(if (SetInterrogationFlag 76)
					(++ iconValue)
				)
				(if (== gDay 10)
					(= iconValue 212) ; "Talkin' about that won't help at this point."
				)
				(self sayMessage:)
			)
			(10 ; V\82v\82
				(= iconValue 121) ; "WHAT?"
				(if (SetInterrogationFlag 77)
					(++ iconValue)
				)
				(if (== gDay 10)
					(= iconValue 213) ; "I know what you told me about that Gedde one. That's all I need to know."
				)
				(self sayMessage:)
			)
			(1 ; Voodoo
				(= iconValue
					(cond
						((== gDay 10) 127)
						((SetInterrogationFlag 78) 126)
						(else 125)
					)
				)
				(self sayMessage:)
			)
			(2 ; Voodoo Murders
				(= iconValue 74) ; "Lots. Can you be more specific?"
				(if (SetInterrogationFlag 79)
					(++ iconValue)
				)
				(if (IsFlag 22)
					(= iconValue 76) ; "The case is closed! There's nothin' more to discuss!"
				)
				(if (== gDay 10)
					(= iconValue 77) ; "Well, you and I know who did 'em, don't we? But we've got to prove it to somebody who'll listen!"
				)
				(self sayMessage:)
			)
			(74 ; "Lots. Can you be more specific?"
				(self newNoun: 8)
				(self doVerb:)
			)
			(75 ; "What else do you want to know?"
				(self newNoun: 8)
				(self doVerb:)
			)
			(40 ; Other Six Patterns
				(SetFlag 75)
				(gEgo getPoints: -999 1)
				(self doVerb:)
			)
			(39 ; Pattern Around Bodies
				(SetInterrogationFlag 49)
				(self doVerb:)
			)
			(148 ; Make a Plan
				(SetInterrogationFlag 51)
				(SetFlag 326)
				(self doVerb:)
			)
			(else
				(self doVerb:)
			)
		)
	)
)

(instance granny of Interrogation
	(properties
		curNoun 6
		sayNoun 4
		verb 83
		modNum 51
		color 8
		index 3
		view 976
		left 245
		top 91
	)

	(method (setPersonals)
		(= personals (IntArray with: 46 49 44 45 48 47 204 50))
		(= personalIndex (IntArray with: 1 2 3 0 4 5 6 7))
	)

	(method (showCases)
		(super
			showCases:
				45 ; Knight Family
				(IsNotInterrogationFlag 87)
				46 ; Harrison Knight
				(IsInterrogationFlag 87)
				48 ; Margaret Templeton Knight
				(IsInterrogationFlag 87)
				47 ; Philip Knight
				(IsInterrogationFlag 87)
				49 ; Heinz Ritter
				(IsFlag 69)
				50 ; Wolfgang Ritter
				(>= gDay 3)
				189 ; How are you feeling these days?
				(IsNotInterrogationFlag 83)
				188 ; Tell me how you met Grandad.
				(IsNotInterrogationFlag 84)
				187 ; Tell me about before you met Grandad.
				(IsNotInterrogationFlag 85)
				186 ; What do you do all day?
				(IsNotInterrogationFlag 86)
				204 ; Complement Her
				(< gDay 5)
		)
	)

	(method (cue)
		(switch iconValue
			(46 ; Harrison Knight
				(SetInterrogationFlag 94)
				(= iconValue (+ 177 (mod (++ local0) 6)))
				(if (and (IsInterrogationFlag 88) (IsInterrogationFlag 89) (IsNotInterrogationFlag 90))
					(SetInterrogationFlag 95)
				)
				(self sayMessage:)
			)
			(49 ; Heinz Ritter
				(= iconValue
					(if (SetInterrogationFlag 91)
						(if (SetInterrogationFlag 92)
							(if (SetInterrogationFlag 93) 200 else 199)
						else
							198
						)
					else
						197
					)
				)
				(gEgo getPoints: 154 2)
				(self sayMessage:)
			)
			(197 ; "Do you know anyone named Heinz Ritter?"
				(SetFlag 282)
				(self doVerb:)
			)
			(45 ; Knight Family
				(SetInterrogationFlag 87)
				(self doVerb:)
			)
			(48 ; Margaret Templeton Knight
				(SetInterrogationFlag 89)
				(= iconValue (+ 172 (mod (++ local1) 5)))
				(if (and (IsInterrogationFlag 94) (IsInterrogationFlag 88) (IsNotInterrogationFlag 90))
					(SetInterrogationFlag 95)
				)
				(self sayMessage:)
			)
			(47 ; Philip Knight
				(SetInterrogationFlag 88)
				(= iconValue (+ 164 (mod (++ local2) 8)))
				(if (and (IsInterrogationFlag 94) (IsInterrogationFlag 89) (IsNotInterrogationFlag 90))
					(SetInterrogationFlag 95)
				)
				(self sayMessage:)
			)
			(204 ; Complement Her
				(= iconValue (+ 205 (mod (++ local3) 5)))
				(self sayMessage:)
			)
			(50 ; Wolfgang Ritter
				(= iconValue
					(cond
						((IsNotInterrogationFlag 91) 201)
						((SetInterrogationFlag 96) 203)
						(else
							(gEgo getPoints: 157 1)
							202
						)
					)
				)
				(self sayMessage:)
			)
			(44 ; Herself
				(= iconValue 184) ; "Me? Surely you have something more interesting to talk about!"
				(if (SetInterrogationFlag 108)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(191 ; Oh, nothing. Never mind.
				(self goTop:)
				(self doVerb:)
			)
			(189 ; How are you feeling these days?
				(SetInterrogationFlag 83)
				(self doVerb:)
			)
			(188 ; Tell me how you met Grandad.
				(SetInterrogationFlag 84)
				(self doVerb:)
			)
			(187 ; Tell me about before you met Grandad.
				(SetInterrogationFlag 85)
				(self doVerb:)
			)
			(186 ; What do you do all day?
				(SetInterrogationFlag 86)
				(self doVerb:)
			)
			(190 ; Just tell me anything at all.
				(= iconValue (+ 192 (mod (++ local4) 5)))
				(self sayMessage:)
			)
			(13 ; Black Voodoo
				(= iconValue 160) ; "Black Voodoo? Is that something new?"
				(if (SetInterrogationFlag 97)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(8 ; Voodoo Hounfour
				(= iconValue 103) ; "Gabriel, my goodness! What ARE you up to these days?"
				(if (SetInterrogationFlag 98)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(7 ; Marie Laveau
				(= iconValue 107) ; "Marie Laveau! Of course! She was that Voodoo woman, wasn't she?"
				(if (SetInterrogationFlag 99)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(3 ; New Orleans
				(= iconValue
					(if (SetInterrogationFlag 100)
						(if (SetInterrogationFlag 101)
							(if (SetInterrogationFlag 102) 163 else 162)
						else
							110
						)
					else
						109
					)
				)
				(self sayMessage:)
			)
			(15 ; Rada Drums
				(= iconValue 113) ; "Rada drums? Your father had a little drum set when he was small...."
				(if (SetInterrogationFlag 103)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(14 ; Schattenj\84ger
				(= iconValue 115) ; "Schattenj\84ger? Schattenj\84ger. How odd, Gabriel. I haven't heard that word in years!"
				(if (SetInterrogationFlag 104)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(4 ; Snakes
				(= iconValue 117) ; "Snakes? What kind of snakes, Dear?"
				(if (SetInterrogationFlag 105)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(5 ; St. John's Eve
				(= iconValue 119) ; "St. John's Eve? Hmmm. I remember when I was a girl, we always had a St. John's Eve mass."
				(if (SetInterrogationFlag 106)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(1 ; Voodoo
				(= iconValue 125) ; "Voodoo? What an odd question, Gabriel!"
				(if (SetInterrogationFlag 107)
					(++ iconValue)
				)
				(self sayMessage:)
			)
			(else
				(if (ClearInterrogationFlag 95)
					(= iconValue 183) ; "Since you're so interested in family history these days, why don't you go by St. Louis Cemetery #1 and visit the family tomb? It would be a sweet gesture."
					(SetInterrogationFlag 90)
					(SetFlag 77)
					(gEgo getPoints: -999 2)
					(self sayMessage:)
				else
					(self doVerb:)
				)
			)
		)
	)
)

(instance tkMose of Talker
	(properties
		x 236
		y 84
		talkWidth 200
		modeless 2
		fore 4
		back 0
		view 974
		textX -228
		textY 4
	)

	(method (init)
		(= font gUserFont)
		(if (IsFlag 99)
			(= view 9741)
		)
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
		x 254
		y 120
		view 974
		loop 1
	)
)

(instance hisEyes of Prop
	(properties
		x 254
		y 107
		view 974
		loop 2
	)
)

(instance tkGran of Talker
	(properties
		x 245
		y 91
		talkWidth 200
		modeless 2
		fore 8
		back 0
		view 976
		textX -225
		textY -4
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
		x 260
		y 135
		view 976
		loop 1
	)
)

(instance herEyes of Prop
	(properties
		x 259
		y 120
		view 976
		loop 2
	)
)

