;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 116)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use Full)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	omar 0
	giveReward 1
)

(local
	egoAskedOmar
	[ojGenList 38] = [0 26 28 31 33 35 37 39 41 43 45 47 49 51 53 55 57 2 72 59 61 63 65 67 69 72 74 76 78 80 69 82 78 2 2 2 2 2]
	[ojSpecList 16] = [4 '//jaafar' 6 '//rakeesh' 8 '//paladin' 80 '//bazaar,courtyard' 20 '//hero' 22 '//dark,blackness' 84 '//poem' 0 0]
)

(instance giveReward of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 100 160 self)
			)
			(1
				(Face gEgo omar)
				(if (== gDay 11)
					(SolvePuzzle 600 3)
					(omar setScript: omarJaAfarTalk self 12)
				else
					(SolvePuzzle 601 3)
					(SolvePuzzle 602 3)
					(omar setScript: omarJaAfarTalk self 16)
				)
				(SkillUsed 14 50) ; honor
				(ClearFlag 158)
			)
			(2
				(jaAfar loop: 2 setCycle: End)
				(gEgo setMotion: MoveTo 105 142 self)
			)
			(3
				(if (== gDay 11)
					(HighPrint 116 0) ; "You receive a reward of 50 Dinars."
					(gEgo get: 2 50) ; Dinar
				else
					(HighPrint 116 1) ; "You receive a reward of 100 Dinars."
					(gEgo get: 2 100) ; Dinar
				)
				(= cycles 12)
			)
			(4
				(Face gEgo (ScriptID 100 1)) ; shameen
				((ScriptID 100 1) ; shameen
					setLoop: 1
					cycleSpeed: 4
					setCycle: Full 1 self
				)
				(StartTimer (ScriptID 100 3) 20) ; standTimer
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance omarJaAfarTalk of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jaAfar setCycle: End)
				(Say omar self 106 register)
			)
			(1
				(if (OneOf register 28 69)
					(Say omar self 106 (++ register))
				else
					(self cue:)
				)
				(++ register)
			)
			(2
				(jaAfar setCycle: Beg self)
			)
			(3
				(omar loop: 3 setCycle: End)
				(Say jaAfar self 106 register)
			)
			(4
				(omar setCycle: Beg self)
			)
			(5
				(omar setLoop: 2)
				(self dispose:)
			)
		)
	)
)

(instance OWindow of TopWindow
	(properties
		brLeft 155
		brBottom 200
	)
)

(instance JWindow of TopWindow
	(properties
		brBottom 200
		brRight 110
	)
)

(instance omar of Talker
	(properties
		x 148
		y 107
		description {Omar the Poet}
		lookStr {It is Omar the Poet.}
		view 106
		loop 2
		priority 8
		signal 16400
		illegalBits 0
		tLoop 2
		talkSpeed 1
		myName '//omar,poet'
		title {Omar:}
		color 5
		msgFile 106
	)

	(method (init)
		(super init: &rest)
		(= tWindow OWindow)
		(omarBody init:)
		(jaAfar init:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'give,replace/back,purse,alm')
				(cond
					((not (gEgo use: 55)) ; Purse
						(Say self 116 2) ; "There is no need for that. I am a poet rich in spirit already."
					)
					((IsFlag 135)
						(SkillUsed 14 -100) ; honor
						(CantBePaladin)
						(self setScript: omarJaAfarTalk 0 14)
					)
					(else
						(SolvePuzzle 675 7 3)
						(SkillUsed 14 50) ; honor
						(self setScript: omarJaAfarTalk 0 18)
					)
				)
			)
			(
				(and
					(not
						(and
							(== ((ScriptID 100 2) x:) 37) ; shema
							(== ((ScriptID 100 2) y:) 163) ; shema
						)
					)
					(Said 'thank')
				)
				(if (<= (++ gRoomThanks) 2)
					(SkillUsed 14 10) ; honor
					(SkillUsed 13 5) ; communication
				)
				(SkillUsed 14 2) ; honor
				(self setScript: omarJaAfarTalk 0 24)
			)
		)
	)

	(method (showText what)
		(cond
			((and (not egoAskedOmar) (< gInnLastHere gNow))
				(self setScript: omarJaAfarTalk 0 10)
				(= egoAskedOmar 1)
			)
			((< gInnLastHere gNow)
				(HighPrint 116 3) ; "They do not respond."
			)
			(else
				(self setScript: omarJaAfarTalk 0 what)
			)
		)
	)

	(method (talk &tmp len curStr1 curStr2 [buffer 500] [printRect 4] theWidth)
		(switch state
			(1
				(= curStr1 s1)
				(= curStr2 s2)
			)
			(2
				(= curStr1 s3)
				(= curStr2 s4)
			)
			(3
				(= curStr1 s5)
				(= curStr2 s6)
			)
			(4
				(= curStr1 s7)
				(= curStr2 s8)
			)
		)
		(cond
			((u< curStr1 1000)
				(GetFarText curStr1 curStr2 @buffer)
			)
			(curStr1
				(StrCpy @buffer curStr1)
			)
		)
		(if (< gNumColors 8)
			(tWindow color: 0 back: 15)
		else
			(tWindow color: color back: back)
		)
		(TextSize @[printRect 0] @buffer gUserFont 0)
		(= theWidth (+ [printRect 3] 30))
		(Print
			@buffer
			#font
			gUserFont
			#title
			title
			#window
			tWindow
			#at
			(- 300 theWidth)
			0
			#width
			theWidth
			#mode
			0
			#dispose
		)
		(if (< (= len (/ (StrLen @buffer) 9)) 4)
			(= len 4)
		)
		(if gDebugging
			(= endCycles 0)
		else
			(= endCycles (+ 1 (* gHowFast 1)))
		)
		(= cycles 0)
		(= seconds len)
	)

	(method (atSpec which)
		(return [ojSpecList which])
	)

	(method (atGen which)
		(return [ojGenList which])
	)
)

(instance omarBody of View
	(properties
		x 148
		y 127
		view 106
		priority 8
		signal 16
	)
)

(instance jaAfar of Talker
	(properties
		x 110
		y 127
		description {Ja'Afar}
		lookStr {It is Omar's companion and translator, Ja'Afar.}
		view 108
		priority 8
		signal 16
		illegalBits 0
		tLoop 1
		talkSpeed 1
		myName '//jaafar'
		title {Ja'Afar:}
		color 4
		msgFile 106
	)

	(method (init)
		(= tWindow JWindow)
		(super init: &rest)
	)

	(method (handleEvent event)
		(cond
			((Said 'ask//jaafar')
				(self showText: 4)
			)
			((super handleEvent: event) 0)
		)
	)

	(method (showText what)
		(cond
			((and (not egoAskedOmar) (< gInnLastHere gNow))
				(self setScript: omarJaAfarTalk 0 10)
				(= egoAskedOmar 1)
			)
			((< gInnLastHere gNow)
				(HighPrint 116 3) ; "They do not respond."
			)
			(else
				(self setScript: omarJaAfarTalk 0 what)
			)
		)
	)

	(method (talk &tmp len curStr1 curStr2 [buffer 500] [printRect 4] theWidth)
		(switch state
			(1
				(= curStr1 s1)
				(= curStr2 s2)
			)
			(2
				(= curStr1 s3)
				(= curStr2 s4)
			)
			(3
				(= curStr1 s5)
				(= curStr2 s6)
			)
			(4
				(= curStr1 s7)
				(= curStr2 s8)
			)
		)
		(cond
			((u< curStr1 1000)
				(GetFarText curStr1 curStr2 @buffer)
			)
			(curStr1
				(StrCpy @buffer curStr1)
			)
		)
		(if (< gNumColors 8)
			(tWindow color: 0 back: 15)
		else
			(tWindow color: color back: back)
		)
		(TextSize @[printRect 0] @buffer gUserFont 0)
		(= theWidth (+ [printRect 3] 30))
		(Print
			@buffer
			#font
			gUserFont
			#title
			title
			#window
			tWindow
			#at
			0
			0
			#width
			theWidth
			#mode
			1
			#dispose
		)
		(if (< (= len (/ (StrLen @buffer) 9)) 4)
			(= len 4)
		)
		(if gDebugging
			(= endCycles 0)
		else
			(= endCycles (+ 1 (* gHowFast 1)))
		)
		(= cycles 0)
		(= seconds len)
	)

	(method (atSpec which)
		(return [ojSpecList which])
	)

	(method (atGen which)
		(return [ojGenList which])
	)
)

