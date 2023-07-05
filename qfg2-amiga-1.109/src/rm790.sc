;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 790)
(include sci.sh)
(use Main)
(use n001)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm790 0
)

(local
	ready
	lightningTimer
	[lightning 8]
	[lightningX 4] = [66 111 256 200]
	[lightningY 4] = [35 9 18 -3]
	[bolt 8]
	[boltX 8] = [104 115 130 91 241 218 253 248]
	[boltY 8] = [128 120 120 129 117 120 125 120]
	[sound 6]
	[soundPri 4] = [11 12 13 14]
)

(procedure (soundA &tmp I)
	(for ((= I 0)) (< I 4) ((++ I))
		(= [sound I] (Sound new:))
		([sound I] number: 12 loop: 1 priority: [soundPri I] init:)
	)
)

(procedure (killSound &tmp I)
	(for ((= I 0)) (< I 4) ((++ I))
		([sound I] dispose:)
	)
)

(procedure (addLightning &tmp I)
	(for ((= I 0)) (< I 4) ((++ I))
		(= [lightning I] (aLightning new:))
		([lightning I]
			setLoop: I
			cel: 0
			ignoreActors:
			posn: [lightningX I] [lightningY I]
			init:
		)
	)
)

(procedure (disposeLightning &tmp I)
	(for ((= I 0)) (< I 4) ((++ I))
		([lightning I] dispose:)
	)
)

(procedure (addBolts &tmp I)
	(for ((= I 0)) (< I 8) ((++ I))
		(= [bolt I] (aBolt new:))
		([bolt I]
			setLoop: (mod I 4)
			cel: 0
			ignoreActors:
			posn: [boltX I] [boltY I]
			init:
			hide:
		)
	)
)

(instance aLightning of Extra
	(properties
		view 792
		cycleType 1
		minCycles 1
		maxCycles 2
	)
)

(instance aBolt of Prop
	(properties
		view 792
	)
)

(instance rm790 of Rm
	(properties
		picture 790
		style 6
	)

	(method (init)
		(Load rsVIEW 781 791)
		(Load rsSOUND 12)
		(Load rsPIC 2)
		(= global61 2)
		(super init:)
		(city1 init:)
		(city2 init:)
		(city3 init:)
		(city4 init:)
		(InitAddToPics cityWall)
		(gCSound number: 340 loop: 1 priority: 15 playBed:)
		(soundA)
		(self setScript: rising)
	)

	(method (doit)
		(if ready
			(if (mod ([lightning 0] cel:) 2)
				([sound 0] init: play:)
				(leftArmFlash show:)
				(ShakeScreen 1 ssLEFTRIGHT)
			else
				(leftArmFlash hide:)
			)
			(if (mod ([lightning 1] cel:) 2)
				([sound 1] init: play:)
				(bodyFlash show:)
				(ShakeScreen 1 ssLEFTRIGHT)
			else
				(bodyFlash hide:)
			)
			(if (mod ([lightning 2] cel:) 2)
				([sound 2] init: play:)
				(rightArmFlash show:)
				(ShakeScreen 1 ssLEFTRIGHT)
			else
				(rightArmFlash hide:)
			)
			(if (mod ([lightning 3] cel:) 2)
				([sound 3] init: play:)
				(headFlash show:)
				(ShakeScreen 1 ssLEFTRIGHT)
			else
				(headFlash hide:)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance rising of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShakeScreen 2 ssLEFTRIGHT)
				(tower init:)
				(firstSmoke setPri: 1 init: cycleSpeed: 2 setCycle: End self)
			)
			(1
				(ShakeScreen 2 ssLEFTRIGHT)
				(secondSmoke
					posn: (- (firstSmoke x:) 3) (- (firstSmoke y:) 1)
					setPri: 1
					init:
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(ShakeScreen 2 ssLEFTRIGHT)
				(lastSmoke
					posn: (- (firstSmoke x:) 44) (- (firstSmoke y:) 47)
					setPri: 2
					init:
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(ShakeScreen 2 ssLEFTRIGHT)
				(firstSmoke dispose:)
				(secondSmoke dispose:)
				(lastSmoke dispose:)
				(torso setPri: 13 init:)
				(head posn: (- (torso x:) 4) (- (torso y:) 48) setPri: 13 init:)
				(body posn: (torso x:) (- (torso y:) 14) setPri: 13 init:)
				(smoke
					posn: (+ (torso x:) 43) (+ (torso y:) 25)
					setPri: 1
					init:
				)
				(rightArm
					posn: (- (torso x:) 16) (- (torso y:) 62)
					setPri: 13
					init:
				)
				(leftArm
					posn: (+ (torso x:) 11) (- (torso y:) 64)
					setPri: 13
					init:
				)
				(= cycles 4)
			)
			(4
				(ShakeScreen 2 ssLEFTRIGHT)
				(head cel: 1 posn: (- (torso x:) 3) (- (torso y:) 58))
				(body cel: 1 posn: (+ (torso x:) 1) (- (torso y:) 14))
				(smoke cel: 1 posn: (+ (torso x:) 40) (+ (torso y:) 25))
				(rightArm cel: 1 posn: (- (torso x:) 32) (- (torso y:) 54))
				(leftArm cel: 1 posn: (+ (torso x:) 37) (- (torso y:) 49))
				(torso dispose:)
				(addLightning)
				(addBolts)
				(headFlash
					posn: (- (torso x:) 2) (- (torso y:) 64)
					setPri: 15
					init:
					hide:
				)
				(bodyFlash
					posn: (- (torso x:) 2) (- (torso y:) 49)
					setPri: 15
					init:
					hide:
				)
				(leftArmFlash
					posn: (- (torso x:) 51) (- (torso y:) 15)
					setPri: 15
					init:
					hide:
				)
				(leftHandFlash
					posn: (- (torso x:) 50) (+ (torso y:) 11)
					setPri: 15
					init:
					hide:
				)
				(rightArmFlash
					posn: (+ (torso x:) 58) (- (torso y:) 16)
					setPri: 15
					init:
					hide:
				)
				(rightHandFlash
					posn: (+ (torso x:) 78) (+ (torso y:) 10)
					setPri: 15
					init:
					hide:
				)
				([bolt 0] setScript: leftBolt)
				([bolt 4] setScript: rightBolt)
				(= ready 1)
				(= cycles 4)
			)
			(5
				(ShakeScreen 2 ssLEFTRIGHT)
				(= seconds 3)
			)
			(6
				(city1 palette: 2 cycleSpeed: 2 setCycle: End)
				(city2 palette: 2 cycleSpeed: 2 setCycle: End)
				(city3 palette: 2 cycleSpeed: 2 setCycle: End)
				(city4 palette: 2 cycleSpeed: 2 setCycle: End)
				(ShakeScreen 2 ssLEFTRIGHT)
				(= cycles 2)
			)
			(7
				(ShakeScreen 2 ssLEFTRIGHT)
				(fire2 init: setCycle: Fwd)
				(= cycles 2)
			)
			(8
				(ShakeScreen 2 ssLEFTRIGHT)
				(= seconds 8)
			)
			(9
				(= ready 0)
				(= cycles 12)
			)
			(10
				(tower setCycle: End self)
			)
			(11
				(disposeLightning)
				(killSound)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 2)
				(= seconds 3)
			)
			(12
				(EgoDead 1 790 0 #title {The end of the world!}) ; "You did your best, but it just wasn't good enough."
			)
		)
	)
)

(instance leftBolt of Script
	(properties)

	(method (doit)
		(if (mod (client cel:) 2)
			(leftHandFlash show:)
		else
			(leftHandFlash hide:)
		)
		(super doit:)
	)

	(method (changeState newState &tmp I)
		(switch (= state newState)
			(0
				(for ((= I 0)) (< I 4) ((++ I))
					([sound I] init: play:)
					([bolt I] show: setCycle: End)
				)
				(= cycles 10)
			)
			(1
				(for ((= I 0)) (< I 4) ((++ I))
					([bolt I] cel: 0 hide:)
				)
				(= cycles 1)
			)
			(2
				(= cycles (Random 5 25))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance rightBolt of Script
	(properties)

	(method (doit)
		(if (mod (client cel:) 2)
			(rightHandFlash show:)
		else
			(rightHandFlash hide:)
		)
		(super doit:)
	)

	(method (changeState newState &tmp I)
		(switch (= state newState)
			(0
				(for ((= I 4)) (< I 8) ((++ I))
					([sound (- I 4)] init: play:)
					([bolt I] show: setCycle: End)
				)
				(= cycles 10)
			)
			(1
				(for ((= I 4)) (< I 8) ((++ I))
					([bolt I] cel: 0 hide:)
				)
				(= cycles 1)
			)
			(2
				(= cycles (Random 5 25))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance crashSound of Sound ; UNUSED
	(properties
		number 12
		priority 13
	)
)

(instance tower of Prop
	(properties
		x 230
		y 140
		view 792
		loop 7
	)
)

(instance firstSmoke of Prop
	(properties
		x 201
		y 137
		view 781
		signal 16384
	)
)

(instance secondSmoke of Prop
	(properties
		view 781
		loop 1
		signal 16384
	)
)

(instance lastSmoke of Prop
	(properties
		view 781
		loop 2
		signal 16384
	)
)

(instance head of View
	(properties
		view 791
	)
)

(instance body of View
	(properties
		view 791
		loop 1
	)
)

(instance smoke of View
	(properties
		view 791
		loop 2
		cel 1
	)
)

(instance rightArm of View
	(properties
		view 791
		loop 3
		cel 1
	)
)

(instance leftArm of View
	(properties
		view 791
		loop 4
		cel 1
	)
)

(instance torso of View
	(properties
		x 160
		y 110
		view 791
		loop 1
	)
)

(instance headFlash of View
	(properties
		view 791
		cel 2
		priority 12
		signal 16
	)
)

(instance bodyFlash of View
	(properties
		view 791
		loop 1
		cel 2
		priority 15
		signal 16
	)
)

(instance leftArmFlash of View
	(properties
		view 791
		loop 3
		cel 2
		priority 12
	)
)

(instance leftHandFlash of View
	(properties
		view 791
		loop 3
		cel 3
		priority 12
	)
)

(instance rightArmFlash of View
	(properties
		view 791
		loop 4
		cel 2
		priority 12
	)
)

(instance rightHandFlash of View
	(properties
		view 791
		loop 4
		cel 3
		priority 12
	)
)

(instance cityWall of PicView
	(properties
		x 155
		y 155
		view 790
		priority 2
		signal 16400
	)
)

(instance city1 of Prop
	(properties
		x 219
		y 140
		view 790
		loop 2
		priority 1
		signal 16400
		palette 1
	)
)

(instance city2 of Prop
	(properties
		x 181
		y 143
		view 790
		loop 3
		priority 1
		signal 16400
		palette 1
	)
)

(instance city3 of Prop
	(properties
		x 147
		y 137
		view 790
		loop 4
		priority 1
		signal 16400
		palette 1
	)
)

(instance city4 of Prop
	(properties
		x 104
		y 139
		view 790
		loop 5
		priority 1
		signal 16400
		palette 1
	)
)

(instance fire1 of Prop ; UNUSED
	(properties
		x 186
		y 134
		view 790
		loop 6
		priority 2
		signal 16400
	)
)

(instance fire2 of Prop
	(properties
		x 203
		y 134
		view 790
		loop 7
		priority 2
		signal 16400
	)
)

(instance fire3 of Prop ; UNUSED
	(properties
		x 118
		y 133
		view 790
		loop 6
		priority 2
		signal 16400
	)
)

(instance fire4 of Prop ; UNUSED
	(properties
		x 146
		y 133
		view 790
		loop 7
		priority 2
		signal 16400
	)
)

(instance aRock of Actor ; UNUSED
	(properties
		yStep 18
		view 792
		signal 16384
		illegalBits 0
		xStep 18
	)
)

