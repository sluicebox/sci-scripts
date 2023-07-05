;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	madonnaScript 0
	madonna 1
	madonnaFace 2
)

(instance madonnaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(madonna setLoop: 0 cel: 0 setCycle: Fwd)
				(= seconds (Random 3 5))
			)
			(1
				(madonna setCycle: End self)
			)
			(2
				(if (!= (madonna loop:) 6)
					(madonna
						setLoop: (+ (madonna loop:) 1)
						cel: 0
						setCycle: End self
					)
				else
					(self changeState: 0)
				)
			)
			(3
				(gLongSong send: 6 78 0)
				(switch (madonna loop:)
					(1
						(madonnaFace posn: 140 52 setLoop: 7)
					)
					(2
						(madonnaFace posn: 147 60 setLoop: 8)
					)
					(3
						(madonnaFace posn: 140 50 setLoop: 7)
					)
					(4
						(madonnaFace posn: 135 53 setLoop: 8)
					)
					(5
						(madonnaFace posn: 130 60 setLoop: 7)
					)
					(6
						(madonnaFace posn: 140 50 setLoop: 7)
					)
				)
				(madonnaFace show:)
				(= cycles (Random 90 120))
			)
			(4
				(gLongSong send: 6 78 1)
				(madonnaFace hide:)
				(= cycles (= state 1))
			)
		)
	)
)

(instance madonna of Prop
	(properties
		x 138
		y 91
		description {humanoid}
		lookStr {On stage, a strangely attired woman performs her act (if that's what you want to call it). You haven't had a girlfriend for a long time (more like forever), but even that's not enough to make her attractive.}
		view 435
		signal 18432
		cycleSpeed 4
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 301 0) ; "No thanks."
			)
			(11 ; Taste
				(Print 301 1) ; "Her taste in clothes is almost as bad as her taste in music."
			)
			(12 ; Smell
				(Print 301 2) ; "You'd love to, but those spikes look deadly."
			)
			(5 ; Talk
				(Print 301 3) ; "She doesn't have the time to talk to you."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 301 4) ; "If you think that's going to work on her, you're loony."
					)
					(0 ; Cartridge
						(Print 301 5) ; "She doesn't find the cartridge any more interesting than the rest of you."
					)
					(15 ; Widget
						(Print 301 6) ; "She could care less about the widget."
					)
					(2 ; Gadget
						(Print 301 7) ; "You can understand her fine already."
					)
					(4 ; Knife
						(Print 301 8) ; "She apparently has no interest in male competence symbols."
					)
					(5 ; Dehydrated_Water
						(Print 301 9) ; "She just keeps on singing as you hold out the canister of dehydrated water."
					)
					(11 ; Jetpack
						(Print 301 10) ; "With a toss of peroxide hair, she rebuffs your offer of a jet pack."
					)
					(17 ; Bar_Coupon
						(Print 301 11) ; "The coupon probably doesn't apply in this situation."
					)
					(18 ; Droids-B-Us_coupon
						(Print 301 11) ; "The coupon probably doesn't apply in this situation."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance madonnaFace of Prop
	(properties
		x 142
		y 91
		description {humanoid}
		lookStr {On stage, a strangely attired woman performs her act (if that's what you want to call it). You haven't had a girlfriend for a long time (more like forever), but even that's not enough to make her attractive.}
		view 435
		loop 7
		priority 6
		signal 18448
		cycleSpeed 4
	)

	(method (doVerb theVerb)
		(madonna doVerb: theVerb &rest)
	)
)

