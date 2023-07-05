;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use TopWindow)
(use TargActor)
(use Interface)
(use Save)
(use Motion)
(use User)

(public
	Say 0
)

(procedure (Say whom)
	(whom messages: &rest)
)

(class Talker of TargActor
	(properties
		caller 0
		tWindow 0
		tLoop 0
		talkSpeed 2
		said 0
		myName 0
		title 0
		color 0
		back 15
		msgFile 0
		s1 0
		s2 0
		s3 0
		s4 0
		s5 0
		s6 0
		s7 0
		s8 0
		tCount 0
		oldLoop 0
		oldCel 0
		oldSpeed 0
		oldCycler 0
		state 0
		seconds 0
		lastSeconds 0
		endCycles 0
		cycles 0
	)

	(method (init)
		(super init: &rest)
		(= tWindow TopWindow)
		(gKeyDownHandler add: self)
		(if (and myName (not noun))
			(= noun (+ myName 1))
		)
	)

	(method (handleEvent event &tmp question)
		(cond
			((super handleEvent: event))
			((Said 'ask/identity')
				(self respond: event 32)
			)
			((and (Said 'ask>') (self saidMe: event))
				(if (< (++ gRoomAsks) 5)
					(SkillUsed 13 5) ; communication
					(SkillUsed 1 3) ; intelligence
				)
				(if (and (not (= question (AskWhat event))) (Said myName))
					(= question 32)
				)
				(self respond: event question)
			)
			((not (or s1 s2)))
			((or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD))
				(event claimed: 1)
				(if (> cycles endCycles)
					(self talkCue:)
				)
			)
		)
		(event claimed:)
	)

	(method (saidMe event &tmp ret)
		(if (= ret (or (Said noun) (Said '[/!*]')))
			(event claimed: 0)
		)
		(return ret)
	)

	(method (respond event question &tmp answer specAnswer)
		(if (or (== (gEgo view:) 0) (== (gEgo view:) 4))
			(gEgo setMotion: 0)
			(Face gEgo self)
		)
		(= answer (self atGen: question))
		(if (not question)
			(if (!= (= specAnswer (self atSpecAnswer:)) 32767)
				(= answer specAnswer)
			)
			(event claimed: 1)
		)
		(self showText: answer)
	)

	(method (atSpecAnswer)
		(self scanSaidSpecs: 427)
	)

	(method (scanSaidSpecs atMethod &tmp i answer saidSpec)
		(= answer 32767)
		(for ((= i 1)) (= saidSpec (self atMethod: i)) ((+= i 2))
			(if (Said saidSpec)
				(= answer (self atMethod: (- i 1)))
				(break)
			)
		)
		(return answer)
	)

	(method (atSpec)
		(return 0)
	)

	(method (atGen)
		(return 0)
	)

	(method (showText what)
		(self messages: msgFile what)
	)

	(method (showMany first last)
		(switch (+ (- last first) 1)
			(1
				(self messages: msgFile (+ first 0))
			)
			(2
				(self messages: msgFile (+ first 0) msgFile (+ first 1))
			)
			(3
				(self
					messages:
						msgFile
						(+ first 0)
						msgFile
						(+ first 1)
						msgFile
						(+ first 2)
				)
			)
			(4
				(self
					messages:
						msgFile
						(+ first 0)
						msgFile
						(+ first 1)
						msgFile
						(+ first 2)
						msgFile
						(+ first 3)
				)
			)
		)
	)

	(method (talkTo event &tmp question)
		(if (Said '/[/!*]')
			(= question 32)
		else
			(if (< (++ gRoomAsks) 5)
				(SkillUsed 13 6) ; communication
				(SkillUsed 1 3) ; intelligence
			)
			(if (and (not (= question (AskWhat event))) (Said myName))
				(= question 32)
			)
		)
		(self respond: event question)
	)

	(method (messages args &tmp curStrArg str1 str2 inc)
		(= curStrArg (= s1 (= s2 (= s3 (= s4 (= s5 (= s6 (= s7 (= s8 0)))))))))
		(= inc 0)
		(if (IsObject [args 0])
			(= caller [args 0])
			(++ curStrArg)
		)
		(= tCount 0)
		(while (< curStrArg argc)
			(cond
				((u< [args curStrArg] 1000)
					(= str1 [args curStrArg])
					(= str2 [args (+ curStrArg 1)])
					(= inc 2)
				)
				([args curStrArg]
					(= str1 [args curStrArg])
					(= str2 0)
					(= inc 1)
				)
				(else
					(break)
				)
			)
			(switch tCount
				(0
					(= s1 str1)
					(= s2 str2)
				)
				(1
					(= s3 str1)
					(= s4 str2)
				)
				(2
					(= s5 str1)
					(= s6 str2)
				)
				(3
					(= s7 str1)
					(= s8 str2)
				)
			)
			(++ tCount)
			(+= curStrArg inc)
		)
		(if (>= state 0)
			(self initTalk:)
		)
	)

	(method (cue)
		(if (== state -1)
			(self talkCue:)
		else
			(super cue:)
		)
	)

	(method (talkCue)
		(++ state)
		(cond
			((== state 0)
				(self initTalk:)
			)
			((<= state tCount)
				(cls)
				(self talk:)
			)
			(else
				(self endTalk:)
			)
		)
	)

	(method (initTalk)
		(= seconds 0)
		(= state 1)
		(= tCount
			(cond
				((or s7 s8) 4)
				((or s5 s6) 3)
				((or s3 s4) 2)
				((or s1 s2) 1)
				(else 0)
			)
		)
		(if (>= tLoop 0)
			(= oldLoop loop)
			(= oldCel cel)
			(= oldSpeed cycleSpeed)
			(= loop tLoop)
			(= cycleSpeed talkSpeed)
			(= oldCycler cycler)
			(= cycler 0)
			(self setCycle: Fwd)
		)
		(cls)
		(self talk:)
	)

	(method (talk &tmp len curStr1 curStr2 [buffer 500])
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
		(Print
			@buffer
			#font
			gUserFont
			#title
			title
			#window
			(if tWindow tWindow else SysWindow)
			#width
			(if tWindow
				(- (tWindow brRight:) (+ (tWindow brLeft:) 16))
			else
				-1
			)
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

	(method (endTalk &tmp theCaller)
		(if (or s1 s2)
			(if (>= tLoop 0)
				(self
					setCycle: oldCycler
					loop: oldLoop
					cel: oldCel
					cycleSpeed: oldSpeed
				)
				(= oldCycler 0)
			)
			(cls)
			(= state 0)
			(self
				tCount: 0
				s1: 0
				s2: 0
				s3: 0
				s4: 0
				s5: 0
				s6: 0
				s7: 0
				s8: 0
				seconds: 0
			)
			(if caller
				(= theCaller caller)
				(= caller 0)
				(theCaller cue:)
			)
		)
	)

	(method (doit &tmp thisSeconds)
		(++ cycles)
		(if seconds
			(= thisSeconds (GetTime 1)) ; SysTime12
			(if (!= lastSeconds thisSeconds)
				(= lastSeconds thisSeconds)
				(if (not (-- seconds))
					(self talkCue:)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(if (IsObject oldCycler)
			(oldCycler dispose:)
			(= oldCycler 0)
		)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp theEvent)
		(if (== theVerb 9)
			(= theEvent (User curEvent:))
			(theEvent claimed: 0)
			(self talkTo: theEvent)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

