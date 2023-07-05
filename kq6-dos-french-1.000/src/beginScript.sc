;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use Kq6Talker)
(use n913)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	beginScript 0
	riddleBookScript 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(instance beginScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable: 6)
				(if (not (IsFlag 129))
					(SetFlag 129)
					(gGame givePoints: 1)
				)
				(gMessager say: 1 27 0 1 self 0) ; "Alexander opens the rare book and looks inside."
			)
			(1
				(= seconds 2)
			)
			(2
				(gEgo
					normal: 0
					view: 903
					cel: 0
					setLoop: 2
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(3
				(gEgo cel: 0 setLoop: 0 setCycle: End self)
			)
			(4
				(gEgo setLoop: 1 setCycle: Fwd)
				(= seconds 4)
			)
			(5
				(client setScript: (ScriptID 90 1)) ; riddleBookScript
			)
		)
	)
)

(instance riddleBookScript of Script
	(properties)

	(method (init)
		(= local9 gMessager)
		(= gMessager rBookMessager)
		(= local0 gCast)
		(= local1 gFeatures)
		(= local2 gAddToPics)
		(= local3 gMouseDownHandler)
		(= local4 gKeyDownHandler)
		(= local5 gDirectionHandler)
		(= local6 gWalkHandler)
		(= local7 (gCurRoom obstacles:))
		(gCurRoom obstacles: ((List new:) add: yourself:))
		((= gCast (EventHandler new:)) name: {newCast} add:)
		((= gFeatures (EventHandler new:)) name: {newFeatures} add: self)
		((= gAddToPics (EventHandler new:)) name: {newATPs} add:)
		((= gMouseDownHandler (EventHandler new:)) name: {newMH} add: self)
		((= gKeyDownHandler (EventHandler new:)) name: {newKH} add: self)
		((= gDirectionHandler (EventHandler new:)) name: {newDH} add: self)
		((= gWalkHandler (EventHandler new:)) name: {newWH} add:)
		(if register
			(gInventory hide:)
			(= register 0)
		)
		(DrawPic 98)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(background init:)
				(bookView init: stopUpd:)
				(= seconds 2)
			)
			(1
				(gMessager say: 1 27 0 2 self 0) ; "The book contains riddles and has a page missing. Alexander glances at a few of the conundrums, but finds himself more curious about the one that is missing."
			)
			(2
				(gMessager say: 1 27 0 3 self 0) ; "What was the riddle, he wonders. More importantly, what was the answer?"
			)
			(3
				(gGame handsOn:)
				(gFeatures delete: self)
				(User controls: 0)
				(gTheIconBar disable: 0 3 4 5)
			)
			(4
				(gGame handsOff:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gGame setCursor: gWaitCursor)
				(gCast
					eachElementDo: #dispose
					eachElementDo: #delete
					release:
					dispose:
				)
				(gAddToPics dispose:)
				(gFeatures delete: background self dispose:)
				(gMouseDownHandler delete: self dispose:)
				(gKeyDownHandler delete: self dispose:)
				(gDirectionHandler delete: self dispose:)
				(gWalkHandler delete: self dispose:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: local7)
				(= gCast local0)
				(= gFeatures local1)
				(= gMouseDownHandler local3)
				(= gKeyDownHandler local4)
				(= gDirectionHandler local5)
				(= gWalkHandler local6)
				(= gAddToPics local2)
				(UnLoad 128 904)
				(DrawPic (gCurRoom picture:) 100)
				(if gAddToPics
					(gAddToPics doit:)
				)
				(= seconds 2)
			)
			(5
				(gEgo setLoop: 2 cycleSpeed: 10 lastCel: setCycle: Beg self)
			)
			(6
				(gEgo reset: 2)
				(gTheIconBar enable: 6)
				(gGame handsOn:)
				(self dispose:)
				(= gMessager local9)
				(DisposeScript 90)
			)
		)
	)
)

(instance background of Feature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (doVerb)
		(riddleBookScript cue:)
	)
)

(instance bookView of Prop
	(properties
		x 149
		y 86
		view 904
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(riddleBookScript state: (- (riddleBookScript state:) 3) cue:)
		else
			(background doVerb: theVerb)
		)
	)
)

(instance rBookMessager of Kq6Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(if (== param1 99)
			(= temp0 localNarrator)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

(instance localNarrator of Kq6Narrator
	(properties
		y 135
	)

	(method (init)
		(= talkWidth 280)
		(super init: &rest)
	)
)

