;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 811)
(include sci.sh)
(use Main)
(use KQ6Print)
(use rm810)
(use CartoonScript)
(use n913)
(use Conversation)
(use Scaler)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	studyInset 0
)

(instance studyInset of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 811)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not ((ScriptID 80 0) tstFlag: #rFlag3 16)) ; rgCastle
					(gGame givePoints: 1)
				)
				(self setScript: convScript self)
			)
			(1
				(if (not ((ScriptID 80 0) tstFlag: #rFlag3 16)) ; rgCastle
					((ScriptID 80 0) setFlag: #rFlag3 16) ; rgCastle
					(convScript start: (+ (convScript state:) 1))
					(= register 1)
					(gGlobalSound fadeTo: 150 -1)
					(self setScript: writeLetter self)
				else
					(= register 0)
					(roomConv add: -1 4 1 8 2 init: self) ; "The vizier's study is now empty."
				)
			)
			(2
				(gCast eachElementDo: #startUpd)
				(= cycles 1)
			)
			(3
				(roomConv caller: 0)
				(candles dispose:)
				(feather dispose:)
				(desk dispose:)
				(door dispose:)
				(background dispose:)
				(proc810_1)
				(= cycles 5)
			)
			(4
				(if register
					(gMessager say: 4 1 9 9 self oneOnly: 0) ; "The vizier's words fill Alexander with blazing anger--and fear for Cassima's life."
					(gGlobalSound fadeTo: 810 -1)
				)
				(gEgo setCycle: Beg self)
			)
			(5
				(gGame handsOn:)
				(gEgo reset: 1 900)
				(self dispose:)
			)
		)
	)
)

(instance writeLetter of CartoonScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 59)
				((ScriptID 810 3) setScript: 0 1) ; beam
				(self setScript: inkUp self)
			)
			(1
				(KQ6Print
					font: gUserFont
					posn: -1 10
					say: 0 4 1 9 2 ; "Dear Shadrack. Salutations from the Society of the Black Cloak, etc., etc. My long preparations are about to come to fruition."
					modeless: 1
					ticks: 20
					init: self
				)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(KQ6Print
					font: gUserFont
					posn: -1 10
					say: 0 4 1 9 3 ; "In a matter of minutes, I will wed the lovely <hah-hah> Cassima."
					modeless: 1
					init: self
				)
			)
			(3
				(self setScript: inkUp self)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(KQ6Print
					font: gUserFont
					posn: -1 10
					say: 0 4 1 9 4 ; "Once I've established my power and my crown, I can stage another 'accident.'"
					modeless: 1
					init: self
				)
			)
			(5
				(inkUp start: 0)
				(self setScript: inkUp self)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(KQ6Print
					font: gUserFont
					posn: -1 10
					say: 0 4 1 9 5 ; "The princess has proven infuriatingly stubborn, as you know. She's becoming quite a dangerous little thorn in my side."
					modeless: 1
					init: self
				)
			)
			(7
				(self setScript: inkUp self)
			)
			(8
				(KQ6Print
					font: gUserFont
					posn: -1 10
					say: 0 4 1 9 6 ; "In a way, it's a shame I have to kill her--she is lovely and would be amusing to keep around, but I can't risk her talking treason to one of the guards. So far, I've managed to keep her locked away, but I can't continue that forever."
					modeless: 1
					init: self
				)
			)
			(9
				(KQ6Print
					font: gUserFont
					posn: -1 10
					say: 0 4 1 9 7 ; "Well, on to it now. I'd send her to you but, as you know, I had no luck in doing so with Mordack. I close in triumph--KING Abdul Alhazred."
					modeless: 1
					init: self
				)
			)
			(10
				(self setScript: inkUp self 1)
			)
			(11
				(vizier setLoop: 3 cel: 0 posn: 165 116 priority: 9)
				(= cycles 10)
			)
			(12
				(if ((ScriptID 80 0) tstFlag: #rFlag2 256) ; rgCastle
					(KQ6Print
						font: gUserFont
						posn: -1 10
						modeless: 1
						say: 0 4 1 9 8 ; "I think it's about time to see if Shamir has taken care of the wench as I asked. It's almost time for the wedding."
						init: self
					)
				else
					(KQ6Print
						font: gUserFont
						posn: -1 10
						modeless: 1
						say: 0 4 1 10 1 ; "And now to see to the final preparations. It's almost time for the wedding. Hee, hee!"
						init: self
					)
				)
			)
			(13
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(self setScript: convScript self)
			)
			(14
				(ClearFlag 59)
				(self dispose:)
			)
		)
	)
)

(instance inkUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(vizier setLoop: 2 cel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(1
				(= seconds (Random 3 5))
			)
			(2
				(vizier setCycle: Beg self)
			)
			(3
				(= start state)
				(vizier setLoop: 7 cel: 0 setCycle: End self)
			)
			(4
				(= seconds 2)
			)
			(5
				(if register
					(vizier setLoop: 8 cel: 0 setCycle: CT 1 1 self)
				else
					(vizier setCycle: Beg self)
				)
			)
			(6
				(if register
					(feather init:)
					(vizier setCycle: End self)
				else
					(vizier setLoop: 0 cycleSpeed: 20 setCycle: Rev)
					(self dispose:)
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance convScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 814
					normal: 0
					loop: 0
					cel: 0
					setScale: 0
					scaleX: 128
					scaleY: 128
					x: 164
					y: 169
					setCycle: End self
				)
			)
			(1
				(KQ6Print
					font: gUserFont
					say: 0 4 1 (+ 8 (not ((ScriptID 80 0) tstFlag: #rFlag3 16))) 1 ; rgCastle
					init: self
				)
				(= cycles 10)
			)
			(2
				(gCast eachElementDo: #startUpd)
				(= ticks 1)
			)
			(3
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 802 10)
				(candles setCycle: Fwd init:)
				(door init:)
				(desk addToPic:)
				(background addToPic:)
				(if (not ((ScriptID 80 0) tstFlag: #rFlag3 16)) ; rgCastle
					(feet init:)
					(vizier init:)
					(= cycles 1)
				else
					(feather init:)
					(= seconds 5)
				)
			)
			(4
				(self dispose:)
			)
			(5
				(vizier setCycle: End self)
			)
			(6
				(feet dispose:)
				(vizier
					posn: 153 113
					setLoop: 4
					cel: 0
					setCycle: Walk
					cycleSpeed: 6
					moveSpeed: 6
					setScale: Scaler 100 73 113 103
					setMotion: MoveTo 92 106 self
				)
			)
			(7
				(door hide:)
				(gGlobalSound4 number: 901 loop: 1 play:)
				(vizier
					setLoop: 5
					cel: 0
					cycleSpeed: 8
					posn: 82 72
					setScale: 0
					scaleX: 128
					scaleY: 128
					setCycle: End self
				)
			)
			(8
				(gGlobalSound4 number: 902 loop: 1 play:)
				(door show:)
				(vizier dispose:)
				(= cycles 2)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance roomConv of Conversation
	(properties)
)

(instance background of View
	(properties
		x 154
		y 123
		view 811
		loop 1
		signal 16400
	)
)

(instance feet of View
	(properties
		x 165
		y 115
		view 812
		loop 1
		priority 9
		signal 16400
		scaleSignal 1
	)
)

(instance vizier of Actor
	(properties
		x 164
		y 117
		view 812
		cel 2
		priority 13
		signal 24592
		scaleSignal 1
		cycleSpeed 19
		illegalBits 0
	)
)

(instance desk of View
	(properties
		x 137
		y 89
		view 811
		loop 1
		cel 1
		priority 14
		signal 16
	)
)

(instance candles of Prop
	(properties
		x 185
		y 91
		view 811
		loop 2
		cel 1
		priority 15
		signal 16
	)
)

(instance feather of View
	(properties
		x 170
		y 95
		view 811
		loop 1
		cel 2
		priority 15
		signal 16400
	)
)

(instance door of View
	(properties
		x 92
		y 74
		view 812
		loop 6
		priority 1
		signal 16400
	)
)

