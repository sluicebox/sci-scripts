;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 87)
(include sci.sh)
(use Main)
(use n913)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	egoDrinks 0
	drinkMeScript 1
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
)

(instance egoDrinks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: killSound: 1)
				(gTheIconBar disable:)
				(gMessager say: 1 14 0 1 self 0) ; "Alexander decides to swallow the potion in the bottle labeled 'drink me' to see what happens."
			)
			(1
				(gEgo
					cycleSpeed: 10
					view: 935
					setPri: 14
					cel: 0
					setLoop: 0
					setCycle: End self
				)
				(localMusic number: 925 play: loop: 1)
			)
			(2
				(= seconds 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(= cycles 15)
			)
			(5
				(gMessager say: 1 14 0 2 self 0) ; "Suddenly, his vision fades to black...."
			)
			(6
				(client setScript: (ScriptID 87 1)) ; drinkMeScript
			)
		)
	)
)

(instance drinkMeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
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
				(DrawPic 981 9)
				(= cycles 2)
			)
			(1
				(gMessager say: 1 14 0 3 self 0) ; "His lungs become too heavy to breathe.... His heartbeat slows...."
			)
			(2
				(localMusic number: 926 play: self)
				(newEgo
					init:
					posn: 147 118
					setLoop: 1
					cel: 0
					setPri: 14
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(Palette palSET_FROM_RESOURCE 981)
			)
			(4
				(Palette palSET_FROM_RESOURCE 97)
				(if (== (localMusic prevSignal:) -1)
					(= cycles 1)
				)
			)
			(5
				(if (== (localMusic prevSignal:) 10)
					(-= state 3)
				)
				(= cycles 1)
			)
			(6
				(Palette palSET_FROM_RESOURCE 981)
				(= cycles 1)
			)
			(7
				(= seconds 4)
			)
			(8
				(gMessager say: 1 14 0 4 self 0) ; "Then beats no more!"
			)
			(9
				(= seconds 5)
			)
			(10
				(gMessager say: 1 14 0 5 self 0) ; "Suddenly, his heart takes a lurch, then beats strong...."
			)
			(11
				(localMusic number: 927 play: self)
			)
			(12
				(gMessager say: 1 14 0 6 self 0) ; "His chest heaves like that of a newborn...."
			)
			(13
				(newEgo cel: 0 setLoop: 2 setCycle: End self)
			)
			(14
				(newEgo cel: 0 setLoop: 3 setCycle: End self)
			)
			(15
				(gCast
					eachElementDo: #dispose
					eachElementDo: #delete
					release:
					dispose:
				)
				(gAddToPics dispose:)
				(gFeatures delete: self dispose:)
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
				(DrawPic (gCurRoom picture:) 9)
				(gEgo reset: 2)
				(= cycles 3)
			)
			(16
				(= cycles 3)
			)
			(17
				(gMessager say: 1 14 0 7 self 0) ; "His vision clears, and Alexander feels fine!"
			)
			(18
				(gMessager say: 1 14 0 8 self 0) ; "Phew! For a minute there I thought.... What if someone ELSE had seen me and thought.... Zounds!"
			)
			(19
				(gTheIconBar enable:)
				(gGame handsOn: killSound: 0)
				(SetFlag 153)
				(localMusic stop: dispose:)
				(self dispose:)
				(LoadMany 0 87)
			)
		)
	)
)

(instance localMusic of Sound
	(properties)
)

(instance newEgo of Prop
	(properties
		view 935
	)
)

