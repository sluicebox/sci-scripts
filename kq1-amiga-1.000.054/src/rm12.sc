;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm12 0
)

(procedure (localproc_0)
	(gEgo view: 212 ignoreActors: posn: 183 115 loop: 3 cel: 0 setPri: 9)
	(knifehand
		view: 212
		ignoreActors:
		posn: 193 104
		setCycle: Fwd
		loop: 4
		cel: 0
		setPri: 10
		init:
	)
)

(procedure (localproc_1)
	(knifehand cel: 0 stopUpd:)
	(knifehand dispose:)
)

(procedure (localproc_2)
	(Print 12 58) ; "This side of the well is crumbling to pieces. Try the other side."
)

(procedure (localproc_3)
	(Print 12 59) ; "You can't do that when you are invisible!"
)

(procedure (localproc_4)
	(Print 12 60) ; "The old bucket is at the bottom of the well."
)

(procedure (localproc_5)
	(HandsOn)
	(proc0_1)
	(gEgo loop: 2 posn: 184 135)
)

(procedure (localproc_6)
	(HandsOff)
	(gEgo
		view: 212
		ignoreActors:
		posn: 210 140
		setCycle: Fwd
		loop: 1
		cel: 0
		cycleSpeed: 1
		priority: 12
	)
)

(procedure (localproc_7)
	(Print 12 61) ; "You will find that very difficult to do from here."
)

(procedure (localproc_8)
	(gEgo inRect: 160 115 200 138)
)

(procedure (localproc_9)
	(gEgo inRect: 140 150 218 162)
)

(procedure (localproc_10)
	(Print 12 49) ; "You've cut the rope; there's none to be seen."
)

(instance rm12 of Rm
	(properties
		picture 12
		horizon 74
		north 21
		east 13
		south 5
		west 11
	)

	(method (init)
		(LoadMany rsVIEW 212 61 (if (IsFlag 0) 17 else 15))
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 2)
					(south 4)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_17 275 (gEgo x:) 163) (+ horizon 2))
			)
			(south
				(gEgo posn: (proc0_17 319 (gEgo x:) 90) 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 187 (gEgo y:) 117))
			)
			(else
				(gEgo posn: 317 (proc0_17 187 (gEgo y:) 118))
			)
		)
		(gEgo init:)
		(proc0_1)
		(gAddToPics add: vine eachElementDo: #init doit:)
		(crank setPri: 10 ignoreActors: init: stopUpd:)
		(if
			(not
				(or (IsFlag 20) (IsFlag 21) (gEgo has: 8) (IsFlag 25)) ; Empty_Water_Bucket
			)
			(bucket
				view: 212
				posn: 179 122
				illegalBits: 0
				setPri: 10
				setCel: 1
				setLoop: 5
				ignoreActors:
				init:
				stopUpd:
			)
		)
		(cond
			((gCast contains: bucket)
				(baranrope loop: 0 cel: 0)
			)
			((or (IsFlag 21) (IsFlag 20))
				(baranrope loop: 0 cel: 14)
			)
			((IsFlag 25)
				(baranrope loop: 5 cel: 0)
			)
		)
		(baranrope setPri: 10 ignoreActors: init: stopUpd:)
		(if (and (IsFlag 19) (== gPrevRoomNum 49))
			(gCurRoom setScript: climbOutaWell)
		)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(bush init:)
		(bush2 init:)
		(wellBush init:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'get,get,get,pick,uncoil/vine')
				(Print 12 0) ; "The vines aren't strong enough to be of any use to you."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,clearing]')
						(Print 12 1) ; "You have encountered an old stone well in the middle of these woods."
					)
					((Said '/blossom')
						(Print 12 2) ; "They raise their colorful faces to the sun."
					)
					((Said '<in,down/well')
						(if (gEgo inRect: 163 131 199 161)
							(Print 12 3) ; "The deep well dissolves quickly into darkness; you can barely see the glint of rippling water at the bottom."
						else
							(Print 12 4) ; "You are not close enough to see into the well."
						)
					)
					((Said '<down')
						(if (gEgo inRect: 163 131 199 161)
							(Print 12 3) ; "The deep well dissolves quickly into darkness; you can barely see the glint of rippling water at the bottom."
						else
							(Print 12 5) ; "You see lush green Daventry grass."
						)
					)
					((Said '/well')
						(Print 12 6) ; "The well looks as if it's been here a long time."
					)
					((Said 'look,look/grass,grass')
						(Print 12 5) ; "You see lush green Daventry grass."
					)
					((Said '<in/bucket')
						(if (IsFlag 21)
							(Print 12 7) ; "You can't quite see the bucket well enough to see if anything's in it."
						else
							(event claimed: 0)
						)
					)
					((and (Said '/water') (not (IsFlag 9)))
						(if (gEgo inRect: 163 131 199 161)
							(Print 12 8) ; "From up here, you can't make out any details of the water below."
						else
							(Print 12 9) ; "You don't see any water here."
						)
					)
				)
			)
			((Said 'get,get/water')
				(cond
					((not (gEgo has: 8)) ; Empty_Water_Bucket
						(Print 12 10) ; "All the water is at the bottom of the well."
					)
					((not (IsFlag 9))
						(Print 12 11) ; "Now that you've cut the rope, there's no way for you to get the bucket to the bottom of the well."
					)
					(else
						(Print 12 12) ; "You already have a bucket full of water."
					)
				)
			)
			(
				(or
					(Said '(climb,climb[<down,in]),(go<down)[/rope,well]')
					(Said 'enter/well')
					(Said 'get,get<in,in/well')
					(Said 'slide/rope')
				)
				(cond
					((IsFlag 1)
						(localproc_3)
					)
					((IsFlag 2)
						(Print 12 13) ; "The goat refuses to go down the well."
					)
					((IsFlag 1)
						(localproc_3)
					)
					((localproc_9)
						(localproc_2)
					)
					((localproc_8)
						(event claimed: 0)
						(cond
							((or (IsFlag 21) (IsFlag 20))
								(event claimed: 1)
								(gCurRoom setScript: climbRope)
							)
							((Said '/well')
								(Print 12 14) ; "The sides of this well are too slippery to climb down."
							)
							((IsFlag 25)
								(event claimed: 1)
								(Print 12 15) ; "Since you've cut the rope there is nothing left to climb down on."
							)
							(else
								(event claimed: 1)
								(Print 12 16) ; "You could seriously injure yourself unless you lower the rope first."
							)
						)
					)
					(else
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
				)
			)
			(
				(or
					(Said 'climb,climb[<in]/bucket')
					(Said 'sit[<in]/bucket')
					(Said 'enter/bucket')
					(Said 'get,get<in,in/bucket')
				)
				(cond
					((IsFlag 2)
						(Print 12 17) ; "That bucket isn't big enough for you and that big goat!"
					)
					((IsFlag 1)
						(localproc_3)
					)
					((localproc_9)
						(localproc_2)
					)
					((localproc_8)
						(cond
							((gEgo has: 8) ; Empty_Water_Bucket
								(Print 12 18) ; "You'd look silly sitting in your bucket, since the bucket is no longer attached to the rope."
							)
							((or (IsFlag 21) (IsFlag 25))
								(localproc_4)
							)
							((IsFlag 47)
								(Print 12 19) ; "That would be hard to do from up here."
							)
							(else
								(gCurRoom setScript: intoBucket)
							)
						)
					)
					(else
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
				)
			)
			((Said 'jump/bucket')
				(cond
					((IsFlag 1)
						(localproc_3)
					)
					((localproc_9)
						(localproc_2)
					)
					((gEgo has: 8) ; Empty_Water_Bucket
						(Print 12 20) ; "You can't jump into it while you're holding it."
					)
					((localproc_8)
						(if (or (IsFlag 21) (IsFlag 47))
							(Print 12 21) ; "You jump down the well trying to land near the bucket."
							(gCurRoom setScript: jumpsInWell)
						else
							(Print 12 22) ; "You attempt to jump in the bucket, but miss."
							(gCurRoom setScript: jumpsInWell)
						)
					)
					(else
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
				)
			)
			((Said 'jump')
				(cond
					((IsFlag 1)
						(localproc_3)
					)
					((localproc_9)
						(localproc_2)
					)
					((localproc_8)
						(gCurRoom setScript: jumpsInWell)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'untie/rope')
				(Print 12 23) ; "The knots on the rope are too tight to untie."
			)
			((Said 'untie,get,get/bucket')
				(cond
					((gEgo has: 8) ; Empty_Water_Bucket
						(Print 12 24) ; "You already have the bucket."
					)
					((IsFlag 25)
						(localproc_4)
					)
					((IsFlag 47)
						(Print 12 25) ; "The bucket is floating in the well."
					)
					((gEgo inRect: 163 131 199 161)
						(Print 12 26) ; "The old bucket is securely fastened to a strong rope."
					)
					(else
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
				)
			)
			(
				(or
					(Said 'lower/bucket')
					(and (gCast contains: bucket) (Said 'lower/rope'))
				)
				(cond
					((gEgo has: 8) ; Empty_Water_Bucket
						(Print 12 27) ; "You've already got the bucket!"
					)
					((IsFlag 25)
						(localproc_10)
					)
					((IsFlag 21)
						(localproc_4)
					)
					((IsFlag 47)
						(Print 12 28) ; "The bucket is floating."
					)
					(script
						(script doit:)
						(PrintTooBusy)
					)
					((IsFlag 1)
						(localproc_3)
					)
					((gEgo inRect: 190 115 230 138)
						(gCurRoom setScript: crankDown)
					)
					(else
						(localproc_7)
					)
				)
			)
			((Said 'lower/rope')
				(cond
					((IsFlag 25)
						(localproc_10)
					)
					((IsFlag 20)
						(Print 12 29) ; "The rope is already at the bottom of the well."
					)
					((IsFlag 1)
						(localproc_3)
					)
					((gEgo inRect: 190 115 230 138)
						(gCurRoom setScript: crankDown)
					)
					(else
						(localproc_7)
					)
				)
			)
			(
				(or
					(Said 'raise/bucket')
					(and (not (IsFlag 47)) (IsFlag 21) (Said 'raise/rope'))
				)
				(if (gEgo inRect: 190 115 230 138)
					(cond
						((IsFlag 1)
							(localproc_3)
						)
						((gEgo has: 8) ; Empty_Water_Bucket
							(Print 12 30) ; "The bucket is not here."
						)
						((IsFlag 25)
							(localproc_10)
						)
						((IsFlag 47)
							(Print 12 31) ; "Unfortunately, the rope is no longer attached to the bucket."
						)
						((not (IsFlag 21))
							(Print 12 32) ; "The old bucket is already at the top of the well."
						)
						(else
							(gCurRoom setScript: crankUp)
						)
					)
				else
					(localproc_7)
				)
			)
			((Said 'raise/rope')
				(cond
					((IsFlag 25)
						(localproc_10)
					)
					((not (IsFlag 20))
						(Print 12 33) ; "The rope is already at the top of the well."
					)
					((IsFlag 1)
						(localproc_3)
					)
					(else
						(gCurRoom setScript: crankUp)
					)
				)
			)
			((Said 'turn/crank,handle')
				(cond
					((IsFlag 25)
						(localproc_10)
					)
					((IsFlag 1)
						(localproc_3)
					)
					((not (gEgo inRect: 190 115 230 138))
						(localproc_7)
					)
					((IsFlag 20)
						(gCurRoom setScript: crankUp)
					)
					((not (IsFlag 20))
						(gCurRoom setScript: crankDown)
					)
				)
			)
			((Said 'tie,drop,drop/bucket')
				(if (gEgo has: 8) ; Empty_Water_Bucket
					(Print 12 34) ; "The bucket will be of the most use to you if you don't let go of it."
				else
					(proc0_6) ; "You don't have anything that fits that description in your inventory."
				)
			)
			((or (Said 'cut/rope') (Said 'cut<off/bucket'))
				(cond
					((not (gEgo has: 0)) ; Dagger
						(Print 12 35) ; "You have no way to cut the rope."
					)
					((IsFlag 1)
						(localproc_3)
					)
					((localproc_9)
						(localproc_2)
					)
					((localproc_8)
						(cond
							((IsFlag 21)
								(gCurRoom setScript: cutLowered)
							)
							((IsFlag 20)
								(gCurRoom setScript: cutLowered)
							)
							((IsFlag 25)
								(Print 12 36) ; "Unfortunately, the rope is now in pieces in the bottom of the well."
							)
							((IsFlag 47)
								(Print 12 37) ; "The bucket is floating freely at the bottom of the well."
							)
							((not (gEgo has: 8)) ; Empty_Water_Bucket
								(gCurRoom setScript: cutOffBucket)
							)
							(else
								(Print 12 38) ; "The rope is still wound up at the top of the well."
							)
						)
					)
					(else
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
				)
			)
		)
	)
)

(instance rope of Prop
	(properties
		x 179
		y 125
		view 212
		loop 8
		cycleSpeed 1
	)
)

(instance bucket of Actor
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look<in/bucket')
				(cond
					((gEgo has: 8) ; Empty_Water_Bucket
						(if (IsFlag 9)
							(Print 12 39) ; "You look in the wooden bucket and see water."
						else
							(Print 12 40) ; "You peer into the wooden bucket but find it empty."
						)
					)
					((gEgo inRect: 163 131 199 161)
						(Print 12 41) ; "You peer into the bucket but find it empty."
					)
					(else
						(Print 12 42) ; "Move closer to the well. You can't see in the bucket from here."
					)
				)
			)
			((or (Said 'look,look/bucket') (MousedOn bucket event 3))
				(if (gEgo has: 8) ; Empty_Water_Bucket
					(event claimed: 0)
				else
					(event claimed: 1)
					(self doVerb: 1)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond
					((IsFlag 21)
						(Print 12 43) ; "There is no bucket in sight."
					)
					((gEgo inRect: 163 131 199 161)
						(if (IsFlag 9)
							(Print 12 44) ; "The old bucket holds about a gallon of water."
						else
							(Print 12 45) ; "This weathered old bucket has served the kingdom for years and years. It still holds water as well as it did on the day it was made."
						)
					)
					(else
						(Print 12 46) ; "An old wooden bucket is visible at the top of the well."
					)
				)
			)
		)
	)
)

(instance crank of Prop
	(properties
		x 212
		y 102
		view 212
		loop 2
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/crank,handle')
				(self doVerb: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 12 47) ; "This crank is used to lower and raise the bucket into the well."
			)
		)
	)
)

(instance knifehand of Prop
	(properties
		x 193
		y 104
		view 212
		loop 9
	)
)

(instance baranrope of Prop
	(properties
		x 178
		y 94
		view 212
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/rope')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond
					((IsFlag 20)
						(Print 12 48) ; "The rope extends down into the blackness of the well."
					)
					((IsFlag 25)
						(Print 12 49) ; "You've cut the rope; there's none to be seen."
					)
					(else
						(Print 12 50) ; "The rope is wound around the crank, hanging above the well."
					)
				)
			)
		)
	)
)

(instance vine of PicView
	(properties
		x 180
		y 157
		description {vine}
		sightAngle 180
		closeRangeDist 500
		longRangeDist 500
		view 212
		loop 6
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/vine')
				(self doVerb: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 12 51) ; "A healthy tangle of vines is coiled around the well."
			)
		)
	)
)

(instance jumpsInWell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 183 135 self)
			)
			(1
				(gEgo
					view: (if (IsFlag 0) 17 else 15)
					setLoop: 0
					cel: 0
					setStep: 1 5
					setMotion: MoveTo 177 119
					setCycle: End self
				)
			)
			(2
				(baranrope setPri: 11)
				(bucket setPri: 11)
				(gEgo
					setCel: 6
					setPri: 10
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 181 184 self
				)
			)
			(3
				(ClearFlag 2)
				(FadeBackSound)
				(gCurRoom newRoom: 49)
			)
		)
	)
)

(instance intoBucket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 183 135 self)
			)
			(1
				(gEgo
					view: 212
					loop: 7
					cel: 0
					setPri: 10
					illegalBits: 0
					ignoreActors:
					posn: 179 122
					cycleSpeed: 1
					setCycle: End self
				)
				(bucket dispose:)
			)
			(2
				((ScriptID 0 21) number: 24 loop: -1 init: play:) ; gameSound
				(gEgo
					setLoop: 5
					setCel: 2
					setStep: 0 1
					setMotion: MoveTo 179 155
				)
				(crank setCycle: Fwd)
				(baranrope setCycle: End self)
			)
			(3
				(baranrope stopUpd:)
				(bucket stopUpd:)
				(rope init: setPri: 10 setCycle: Fwd)
				(= cycles 25)
			)
			(4
				(rope dispose:)
				((ScriptID 0 21) stop:) ; gameSound
				(Print 12 52) ; "After you are in the old bucket, your weight causes it to slowly descend."
				(SetFlag 18)
				(SetFlag 20)
				(HandsOn)
				(FadeBackSound)
				(gCurRoom newRoom: 49)
			)
		)
	)
)

(instance crankUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (== (gEgo x:) 215) (== (gEgo y:) 135))
					(self changeState: 2)
				else
					(gEgo setMotion: MoveTo 215 132 self)
				)
			)
			(1
				(gEgo setMotion: MoveTo 215 135 self)
			)
			(2
				((ScriptID 0 21) number: 24 loop: -1 init: play:) ; gameSound
				(localproc_6)
				(crank hide:)
				(= cycles 5)
			)
			(3
				(baranrope stopUpd:)
				(bucket stopUpd:)
				(rope init: setPri: 11 setCycle: Rev)
				(= cycles 25)
			)
			(4
				(rope dispose:)
				(localproc_6)
				(if (and (not (gEgo has: 8)) (not (IsFlag 47))) ; Empty_Water_Bucket
					(bucket
						view: 212
						init:
						setStep: 0 1
						setPri: 10
						illegalBits: 0
						ignoreActors: 1
						setCycle: 0
						setLoop: 5
						setCel: 1
						posn: 179 149
						setMotion: MoveTo 179 122
					)
				)
				(baranrope cycleSpeed: 1 ignoreActors: setCycle: Beg)
				(= cycles 29)
			)
			(5
				(baranrope stopUpd:)
				(bucket stopUpd:)
				((ScriptID 0 21) stop:) ; gameSound
				(ClearFlag 21)
				(ClearFlag 20)
				(crank show:)
				(HandsOn)
				(proc0_1)
				(gEgo loop: 2)
				(self dispose:)
			)
		)
	)
)

(instance crankDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (== (gEgo x:) 215) (== (gEgo y:) 135))
					(self changeState: 2)
				else
					(gEgo setMotion: MoveTo 215 132 self)
				)
			)
			(1
				(gEgo setMotion: MoveTo 215 135 self)
			)
			(2
				(localproc_6)
				(crank hide:)
				((ScriptID 0 21) number: 24 loop: -1 init: play:) ; gameSound
				(if (gCast contains: bucket)
					(bucket setStep: 0 1 startUpd: setMotion: MoveTo 179 152)
				)
				(baranrope cycleSpeed: 1 ignoreActors: setCycle: End self)
			)
			(3
				(baranrope stopUpd:)
				(bucket stopUpd:)
				(rope init: setPri: 11 setCycle: Fwd)
				(= cycles 25)
			)
			(4
				((ScriptID 0 21) stop:) ; gameSound
				(rope dispose:)
				(crank show:)
				(HandsOn)
				(proc0_1)
				(gEgo loop: 2)
				(if (gCast contains: bucket)
					(Print 12 53) ; "The old bucket disappears into the darkness."
					(SetFlag 20)
					(SetFlag 21)
					(bucket dispose:)
				else
					(Print 12 54) ; "The rope disappears into the darkness."
					(SetFlag 20)
				)
				(self dispose:)
			)
		)
	)
)

(instance cutLowered of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 183 135 self)
			)
			(1
				(localproc_0)
				(= cycles 12)
			)
			(2
				(localproc_1)
				(baranrope loop: 5 setCel: 0 stopUpd:)
				(bucket
					view: 212
					init:
					setLoop: 5
					setCel: 3
					posn: 179 122
					setStep: 1 3
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 179 148 self
				)
			)
			(3
				(bucket stopUpd:)
				(cond
					((and (IsFlag 21) (not (IsFlag 24)))
						(Print 12 55) ; "The rope and bucket are now lost in the bottom of the well."
					)
					((IsFlag 20)
						(Print 12 56) ; "The rope is now lost in the bottom of the well."
					)
				)
				(SetFlag 25)
				(ClearFlag 21)
				(ClearFlag 20)
				(bucket dispose:)
				(localproc_5)
				(self dispose:)
			)
		)
	)
)

(instance cutOffBucket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 183 135 self)
			)
			(1
				(localproc_0)
				(= cycles 12)
			)
			(2
				(localproc_1)
				(bucket dispose:)
				(proc0_7)
				((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
				(Print 12 57 #at -1 110) ; "You cut the bucket off of the rope."
				(SetScore 95 2)
				(gEgo get: 8) ; Empty_Water_Bucket
				(localproc_5)
				(self dispose:)
			)
		)
	)
)

(instance climbRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 188 135 self)
			)
			(1
				(gEgo setHeading: 270)
				(self cue:)
			)
			(2
				(gEgo
					view: 61
					loop: 1
					cel: 0
					posn: 188 117
					setPri: 10
					setCycle: End self
				)
			)
			(3
				(gEgo
					loop: 0
					posn: 179 95
					setCycle: Fwd
					setMotion: MoveTo 179 133 self
				)
			)
			(4
				(SetFlag 19)
				(gCurRoom newRoom: 49)
			)
		)
	)
)

(instance climbOutaWell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 61
					loop: 0
					cel: 0
					setPri: 10
					posn: 179 113
					setMotion: MoveTo 179 95 self
				)
			)
			(1
				(gEgo loop: 1 cel: 5 posn: 188 117 setCycle: Beg self)
			)
			(2
				(proc0_1)
				(gEgo posn: 188 135 loop: 2)
				(ClearFlag 19)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tree1 of NewFeature
	(properties
		x 81
		y 37
		noun '/ceder'
		nsTop -1
		nsBottom 76
		nsRight 162
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Beautiful shade trees abound in this part of Daventry.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 11
		y 96
		noun '/ceder'
		nsTop 76
		nsLeft 3
		nsBottom 116
		nsRight 20
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Beautiful shade trees abound in this part of Daventry.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 81
		y 113
		noun '/ceder'
		nsTop 76
		nsLeft 64
		nsBottom 151
		nsRight 98
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Beautiful shade trees abound in this part of Daventry.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 275
		y 30
		noun '/ceder'
		nsTop -1
		nsLeft 231
		nsBottom 61
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Beautiful shade trees abound in this part of Daventry.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 294
		y 85
		noun '/ceder'
		nsTop 61
		nsLeft 274
		nsBottom 109
		nsRight 315
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Beautiful shade trees abound in this part of Daventry.}
	)
)

(instance bush of NewFeature
	(properties
		x 18
		y 171
		noun '/bush'
		nsTop 154
		nsBottom 189
		nsRight 36
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is typical of the large, leafy vegetation found all throughout Daventry.}
	)
)

(instance bush2 of NewFeature
	(properties
		x 50
		y 179
		noun '/bush'
		nsTop 169
		nsLeft 35
		nsBottom 189
		nsRight 65
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is typical of the large, leafy vegetation found all throughout Daventry.}
	)
)

(instance wellBush of NewFeature
	(properties
		x 141
		y 133
		noun '/bush'
		nsTop 121
		nsLeft 128
		nsBottom 146
		nsRight 155
		description {bush on well}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Several unremarkable plants have rooted themselves at the base of the old stone well.}
	)
)

