;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use RFeature)
(use Chase)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm085 0
)

(local
	local0
	[local1 28] = [0 185 117 185 124 145 97 145 97 140 145 140 145 148 217 148 212 133 248 133 290 183 319 183 319 0 0 0]
)

(instance rm085 of Rm
	(properties
		picture 85
	)

	(method (init)
		(super init:)
		(HandsOn)
		(gAddToPics add: smokeOut1 smokeOut2 thug2Bottom doit:)
		(self setFeatures: thug2Bottom backRoom room addObstacle: poly1)
		(switch gPrevRoomNum
			(28
				(HandsOff)
				(gEgo view: 0 offset: 3 posn: 55 143 init:)
				(self setScript: getKilled)
			)
			(else
				(gEgo view: 0 offset: 3 posn: 165 170 init:)
			)
		)
		(dog init:)
		(smoke1 init:)
		(smoke2 init:)
		(IKHead setScript: headScript init:)
		(thug1 setScript: (drinkScript new:) init:)
		(thug2 setScript: (drinkScript new:) init:)
		(IKArm setCycle: Fwd cycleSpeed: 2 init:)
		(innKeeper init:)
		(gGlobalSound number: 119 loop: -1 vol: 127 play:)
		(poly1 points: @local1 size: 14)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(or (< (gEgo y:) 155) (& (gEgo onControl: 0) $0040))
					(not local0)
				)
				(gGlobalSound number: 120 loop: -1 play:)
				(HandsOff)
				(++ local0)
				(if (not (IsFlag 40))
					(Say 129 85 0 67 20 20 25 10 70 260) ; "You know dat job we pulled yesterday? Where's da rest of da loot...huh? I think one o' you guys is holdin' out on me!"
				else
					(Say 129 85 1 67 20 20 25 10 70 260) ; "We gotta plan our next job, you guys. Hey! How did you get outta da cellar?"
				)
				(gEgo setMotion: MoveTo (gEgo x:) 148)
			)
			((< (gEgo y:) 150)
				(HandsOff)
				(self setScript: attack)
			)
			((& (gEgo onControl: 0) $4000)
				(gCurRoom newRoom: 27)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(gGlobalSound fade:)
		(DisposeScript 977)
		(DisposeScript 985)
		(super dispose:)
	)
)

(instance getKilled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 158 149 self)
			)
			(1
				(client setScript: 0)
			)
		)
	)
)

(instance headScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End)
				(= seconds (Random 3 8))
			)
			(1
				(client setCycle: Beg)
				(= state -1)
				(= seconds (Random 3 8))
			)
		)
	)
)

(instance attack of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if
			(and
				(or (== state 5) (== state 6))
				(not (User canInput:))
				(not (User controls:))
			)
			(= temp1 ((= temp0 (Event new:)) type:))
			(if (proc0_15 temp1 1 4)
				(= seconds 0)
				(= cycles 1)
			)
			(temp0 dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(IKHead dispose:)
				(IKArm dispose:)
				(thug2 setCycle: Beg setScript: 0)
				(innKeeper
					view: 800
					setScript: 0
					setCycle: Walk
					setLoop: -1
					moveSpeed: 1
					setMotion: MoveTo 78 132 self
					startUpd:
				)
				(gEgo setMotion: 0)
				(if (not (IsFlag 40))
					(Say 160 85 2 67 20 20 25 8) ; "Gentlemen, please excuse me. I didn't mean to interrupt your..."
				)
			)
			(1
				(innKeeper setMotion: MoveTo 78 142 self)
			)
			(2
				(dog setCycle: End)
				(thug1
					view: 806
					setScript: 0
					illegalBits: 2048
					setAvoider: (Avoid new:)
					setCycle: Walk
					ignoreActors: 1
					moveSpeed: 1
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
				(innKeeper
					observeControl: 2048
					ignoreActors: 1
					setAvoider: (Avoid new:)
					setMotion: Chase gEgo 20 self
				)
			)
			(3)
			(4
				(cls)
				(innKeeper setMotion: 0 loop: 5)
				(gEgo loop: 1)
				(thug1 loop: 7)
				(= cycles 3)
			)
			(5
				(if (not (IsFlag 40))
					(Say 129 85 3 67 20 20 25 7) ; "Da inn's full. Ain't got no more rooms."
					(thugHead
						x: (thug1 x:)
						y: (- (thug1 y:) 40)
						setPri: (+ (thug1 priority:) 1)
						setCycle: Fwd
						init:
					)
					(PrintDC 85 4 #at 20 20 #dispose) ; "Hey, boss! Dis guy looks like a real troublemaker! Whaddya want me ta do wid 'im?"
					(= seconds 8)
				else
					(= cycles 1)
				)
			)
			(6
				(Load rsSOUND 121)
				(thugHead dispose:)
				(innHead
					x: (+ (innKeeper x:) 1)
					y: (- (innKeeper y:) 34)
					setPri: (+ (innKeeper priority:) 1)
					setCycle: Fwd
					init:
				)
				(if (not (IsFlag 40))
					(PrintDC 85 5 #at 20 20 #dispose) ; "Rub 'im out!"
					(= seconds 5)
				else
					(PrintDC 85 6 #at 20 20 #dispose) ; "Dis time...rub 'im out for good!"
					(= seconds 6)
				)
			)
			(7
				(innHead dispose:)
				(cls)
				(thug1 view: 810 loop: 0 cel: 0 setCycle: End self)
			)
			(8
				(gGlobalSound number: 121 loop: 1 play:)
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 810 loop: 1 cel: 0 setCycle: End self)
			)
			(9
				(if (not (IsFlag 40))
					(Graph grFILL_BOX 0 0 200 320 3 0 0)
					(Graph grUPDATE_BOX 0 0 200 320 1)
					(gCast eachElementDo: #dispose)
					(SetFlag 40)
					(gCurRoom newRoom: 86)
				else
					(= global330 {That wasn't a very smart move!})
					(EgoDead)
				)
			)
		)
	)
)

(instance drinkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 8))
			)
			(1
				(client setCycle: CT 3 1)
				(= seconds 3)
			)
			(2
				(client setCycle: End self)
				(if (< (Random 1 100) 25)
					(= state -1)
				)
			)
			(3
				(client setCycle: CT 1 1)
				(= seconds 1)
			)
			(4
				(client setCycle: CT 0 -1)
				(= seconds 1)
				(if (< (Random 1 100) 25)
					(= state -1)
				else
					(= state 2)
				)
			)
		)
	)
)

(instance IKArm of Prop
	(properties
		y 98
		x 159
		view 802
		loop 1
		priority 10
		signal 16
	)
)

(instance IKHead of Prop
	(properties
		y 88
		x 159
		view 802
		loop 2
	)
)

(instance innHead of Prop
	(properties
		view 800
		loop 4
		cycleSpeed 4
	)
)

(instance innKeeper of Act
	(properties
		y 129
		x 160
		view 802
		signal 1
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 85 7) ; "Huddled over the bar, Graham notices three rough-looking men deep in a serious conversation. Since they're talking in such low tones Graham can't quite hear what they're saying."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 85 8) ; "The three men haven't noticed Graham yet. Perhaps if he got closer...."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance thugHead of Prop
	(properties
		view 806
		loop 6
		cycleSpeed 4
	)
)

(instance thug1 of Act
	(properties
		y 141
		x 170
		view 808
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 85 7) ; "Huddled over the bar, Graham notices three rough-looking men deep in a serious conversation. Since they're talking in such low tones Graham can't quite hear what they're saying."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 85 8) ; "The three men haven't noticed Graham yet. Perhaps if he got closer...."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance thug2Bottom of RPicView
	(properties
		y 141
		x 150
		view 814
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 85 7) ; "Huddled over the bar, Graham notices three rough-looking men deep in a serious conversation. Since they're talking in such low tones Graham can't quite hear what they're saying."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 85 8) ; "The three men haven't noticed Graham yet. Perhaps if he got closer...."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance thug2 of Prop
	(properties
		y 114
		x 145
		view 814
		loop 1
		priority 10
		signal 16400
		cycleSpeed 2
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 85 7) ; "Huddled over the bar, Graham notices three rough-looking men deep in a serious conversation. Since they're talking in such low tones Graham can't quite hear what they're saying."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 85 8) ; "The three men haven't noticed Graham yet. Perhaps if he got closer...."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance dog of Prop
	(properties
		y 128
		x 233
		view 798
		signal 1
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 85 9) ; "A flea-bitten old dog lies asleep in the corner."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 85 10) ; "The dog is just out of Graham's reach."
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 85 11) ; "Graham has nothing to say to a dog."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance backRoom of RFeature
	(properties
		nsTop 69
		nsLeft 215
		nsBottom 122
		nsRight 251
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 85 12) ; "Through an open doorway, Graham can see part of the inn's dining room."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 85 13) ; "The inn's dining room is just a few steps away."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance room of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 85 14) ; "The country inn's tavern looks a bit shabby and run-down. At the bar, Graham notices three men."
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(10 ; Harp
							(PrintDC 85 15) ; "Playing the harp has attracted the attention of the men at the bar."
							(++ local0)
							(gEgo setMotion: MoveTo (gEgo x:) 145)
						)
					)
				)
				(4 ; Talk
					(HandsOff)
					(gGlobalSound number: 120 loop: -1 play:)
					(++ local0)
					(gEgo setMotion: MoveTo (gEgo x:) 145)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance smoke1 of View
	(properties
		y 3
		x 187
		view 798
		loop 3
	)
)

(instance smoke2 of View
	(properties
		y 7
		x 294
		view 798
		loop 3
		cel 1
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance smokeOut1 of PV
	(properties
		y 3
		x 187
		view 292
		loop 3
	)
)

(instance smokeOut2 of PV
	(properties
		y 7
		x 294
		view 292
		loop 4
	)
)

