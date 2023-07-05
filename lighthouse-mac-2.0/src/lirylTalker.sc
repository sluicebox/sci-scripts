;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	lirylTalker 0
)

(instance lirylTalker of Talker
	(properties)

	(method (init)
		(= blinkSpeed (= priority 200))
		(switch gCurRoomNum
			(740
				(self view: 5170 loop: 0 x: 167 y: 177)
				(lirylMouth view: 5170 loop: 0 x: 167 y: 177)
				(lirylEyes
					view: 5170
					loop: 1
					x: (+ (self x:) 18)
					y: (- (self y:) 19)
				)
			)
			(750
				(if (not (IsFlag 253))
					(self view: 5172 loop: 0 x: 269 y: 147)
					(lirylMouth view: 5172 loop: 0 x: 269 y: 147)
					(lirylEyes
						view: 5172
						loop: 1
						x: (self x:)
						y: (- (self y:) 39)
					)
				else
					(self view: 5173 loop: 0 x: 227 y: 198)
					(lirylMouth view: 5173 loop: 0 x: 227 y: 198)
					(lirylEyes
						view: 5173
						loop: 1
						x: (- (self x:) 15)
						y: (- (self y:) 54)
					)
				)
			)
			(760
				(self view: 5171 loop: 0 x: 190 y: 200)
				(lirylMouth view: 5171 loop: 0 x: 190 y: 200)
				(lirylEyes
					view: 5171
					loop: 1
					x: (- (self x:) 11)
					y: (- (self y:) 33)
				)
			)
			(765
				(self view: 5171 loop: 0 x: 190 y: 200)
				(lirylMouth view: 5171 loop: 0 x: 190 y: 200)
				(lirylEyes
					view: 5171
					loop: 1
					x: (- (self x:) 11)
					y: (- (self y:) 33)
				)
			)
		)
		(super init: lirylMouth 0 lirylEyes &rest)
		(lirylEyes setPri: (+ (lirylMouth priority:) 1))
	)

	(method (startAudio)
		(super startAudio: &rest)
		(lirylEyes setCycle: lirylBlink blinkSpeed)
	)
)

(instance lirylMouth of Prop
	(properties)
)

(instance lirylEyes of Prop
	(properties)
)

(instance lirylBlink of Blink
	(properties)

	(method (doit)
		(if (> (lirylMouth cel:) 14)
			(client hide:)
		else
			(client show:)
		)
		(super doit:)
	)
)

