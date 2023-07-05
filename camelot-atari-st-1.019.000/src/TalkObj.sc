;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 911)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Motion)
(use System)

(class TalkObj of Script
	(properties
		actor 0
		tLoop 0
		tCycler 0
		cSpeed 0
		tWindow 0
		noTimer 0
		noDispose 0
		noWidth 0
		preLoop -1
		postLoop -1
		talkCue 0
		tS1 0
		tS2 0
		tS3 0
		tS4 0
		tS5 0
		tS6 0
		tS7 0
		tS8 0
		tCount 0
		oldSpeed 0
		oldCycler 0
	)

	(method (dispose)
		(if oldCycler
			(oldCycler dispose:)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((or (not gModelessDialog) (!= state 4) noDispose) 0)
			(
				(or
					(and (== (event type:) evMOUSEBUTTON) (MousedOn gModelessDialog event 0))
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(event claimed: 1)
				(self changeState: 5)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(if (and actor (== register 0))
					(= oldCycler (actor cycler:))
					(actor cycler: 0)
					(= oldSpeed (actor cycleSpeed:))
					(if (== postLoop -1)
						(= postLoop
							(if (!= tLoop -1)
								tLoop
							else
								(actor loop:)
							)
						)
					)
				)
				(if (and actor (!= preLoop -1) (== register 0))
					(actor loop: preLoop setCycle: End self)
				else
					(self changeState: 3)
				)
			)
			(2
				(cond
					((not actor) 0)
					((== tLoop -1)
						(actor loop: postLoop)
					)
					(else
						(actor loop: tLoop)
					)
				)
				(= cycles 1)
			)
			(3
				(self initTalk:)
			)
			(4
				(self doTalk:)
			)
			(5
				(++ register)
				(if (<= register tCount)
					(= state 3)
				)
				(= seconds 0)
				(= cycles 1)
			)
			(6
				(self endTalk:)
			)
		)
	)

	(method (initTalk)
		(if actor
			(actor loop: tLoop cycleSpeed: cSpeed)
			(actor setCycle: Fwd)
			(= tCycler (actor cycler:))
		)
		(if noDispose
			(= noTimer 1)
		)
		(= seconds 0)
		(= cycles (= register 1))
	)

	(method (doTalk &tmp temp0 temp1 temp2 [temp3 300])
		(= temp1
			(switch register
				(1 tS1)
				(2 tS3)
				(3 tS5)
				(4 tS7)
			)
		)
		(= temp2
			(switch register
				(1 tS2)
				(2 tS4)
				(3 tS6)
				(4 tS8)
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
		(clr)
		(Print
			@temp3
			#font
			4
			#title
			(if tWindow
				(tWindow title:)
			else
				0
			)
			#window
			(if tWindow tWindow else SysWindow)
			#width
			(if (and tWindow (not noWidth))
				(- (tWindow brRight:) (+ (tWindow brLeft:) 16))
			else
				0
			)
			#dispose
		)
		(if (< (= temp0 (/ (StrLen @temp3) 9)) 3)
			(= temp0 3)
		)
		(if (== noTimer 0)
			(Wait 0)
			(= seconds temp0)
		)
	)

	(method (endTalk)
		(if (!= tS1 0)
			(if actor
				(actor
					setCycle: 0
					cycler: oldCycler
					cycleSpeed: oldSpeed
					loop: postLoop
					cel: 0
				)
				(if (== oldCycler 0)
					(actor setCel: 0)
				)
			)
			(if talkCue
				(talkCue cycles: 1)
			)
			(clr)
			(self
				register: 0
				talkCue: 0
				tCount: 0
				tS1: 0
				seconds: 0
				cycles: 0
				noDispose: 0
				noTimer: 0
				noWidth: 0
				preLoop: -1
				postLoop: -1
				oldCycler: 0
			)
		)
	)

	(method (messages param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 0)
		(for ((= temp0 (= tCount 0))) (< temp0 argc) ((+= temp0 temp3))
			(= temp1 [param1 temp0])
			(cond
				((u< [param1 temp0] 1000)
					(= temp2 [param1 (+ temp0 1)])
					(= temp3 2)
				)
				([param1 temp0]
					(= temp2 0)
					(= temp3 1)
				)
				(else
					(break)
				)
			)
			(switch tCount
				(0
					(= tS1 temp1)
					(= tS2 temp2)
				)
				(1
					(= tS3 temp1)
					(= tS4 temp2)
				)
				(2
					(= tS5 temp1)
					(= tS6 temp2)
				)
				(3
					(= tS7 temp1)
					(= tS8 temp2)
				)
			)
			(++ tCount)
		)
		(self changeState: 1)
	)
)

