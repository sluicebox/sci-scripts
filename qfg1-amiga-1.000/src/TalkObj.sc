;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 803)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Motion)
(use System)

(public
	Say 0
)

(procedure (Say whom)
	(whom messages: &rest)
)

(class TalkObj of Script
	(properties
		tWindow 0
		actor 0
		tLoop 0
		cSpeed 0
		isHead 0
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
	)

	(method (cue)
		(++ register)
		(if (<= register tCount)
			(clr)
			(self talk:)
		else
			(self endTalk:)
		)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((= temp0 (event claimed:)))
			((not (or s1 s2)))
			((== (event type:) evMOUSEBUTTON)
				(event claimed: 1)
				(self cue:)
				(= temp0 1)
			)
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				(event claimed: 1)
				(self cue:)
				(= temp0 1)
			)
		)
		(return temp0)
	)

	(method (initTalk)
		(= seconds 0)
		(= register 1)
		(= tCount
			(cond
				((or s7 s8) 4)
				((or s5 s6) 3)
				((or s3 s4) 2)
				((or s1 s2) 1)
				(else 0)
			)
		)
		(if actor
			(= oldLoop (actor loop:))
			(= oldCel (actor cel:))
			(= oldSpeed (actor cycleSpeed:))
			(if isHead
				(actor show:)
			)
			(actor loop: tLoop cycleSpeed: cSpeed setCycle: Fwd)
		)
		(clr)
		(self talk:)
	)

	(method (talk &tmp temp0 temp1 temp2 [temp3 500])
		(switch register
			(1
				(= temp1 s1)
				(= temp2 s2)
			)
			(2
				(= temp1 s3)
				(= temp2 s4)
			)
			(3
				(= temp1 s5)
				(= temp2 s6)
			)
			(4
				(= temp1 s7)
				(= temp2 s8)
			)
		)
		(cond
			((u< temp1 1000)
				(GetFarText temp1 temp2 @temp3)
			)
			(temp1
				(StrCpy @temp3 temp1)
			)
		)
		(Print
			@temp3
			#font
			gUserFont
			#title
			(if tWindow
				(tWindow title:)
			else
				0
			)
			#window
			(if tWindow tWindow else SysWindow)
			#width
			(if tWindow
				(- (tWindow brRight:) (+ (tWindow brLeft:) 16))
			else
				-1
			)
			#dispose
		)
		(if (< (= temp0 (/ (StrLen @temp3) 9)) 3)
			(= temp0 3)
		)
		(= seconds temp0)
	)

	(method (endTalk)
		(if (or s1 s2)
			(if actor
				(actor
					setCycle: 0
					loop: oldLoop
					cel: oldCel
					cycleSpeed: oldSpeed
				)
				(if isHead
					(actor hide:)
				)
			)
			(clr)
			(= register 0)
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
				(caller cue:)
			)
		)
	)

	(method (messages param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 (= s1 (= s2 (= s3 (= s4 (= s5 (= s6 (= s7 (= s8 0)))))))))
		(for ((= temp0 (= tCount 0))) (< temp0 argc) ((+= temp0 temp3))
			(cond
				((u< [param1 temp0] 1000)
					(= temp1 [param1 temp0])
					(= temp2 [param1 (+ temp0 1)])
					(= temp3 2)
				)
				([param1 temp0]
					(= temp1 [param1 temp0])
					(= temp2 0)
					(= temp3 1)
				)
				(else
					(break)
				)
			)
			(switch tCount
				(0
					(= s1 temp1)
					(= s2 temp2)
				)
				(1
					(= s3 temp1)
					(= s4 temp2)
				)
				(2
					(= s5 temp1)
					(= s6 temp2)
				)
				(3
					(= s7 temp1)
					(= s8 temp2)
				)
			)
			(++ tCount)
		)
		(self initTalk:)
	)
)

