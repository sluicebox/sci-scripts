;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 770)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use RandCycle)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm770 0
	O_Riley 19
)

(local
	local0
	local1
	local2
	local3
)

(instance rm770 of LBRoom
	(properties
		picture 770
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 770 771)
		(LoadMany rsSOUND 770)
		(super init:)
		(gGameMusic1 number: 771 loop: -1 flags: 1 play:)
		(gTheIconBar disable:)
		(gGame setCursor: 996)
		(bird init: setScript: sFly)
		(bird2 init: setScript: sLand 0 4)
		(murderer init:)
		(cop2 init: setScript: (sRandomScr new:))
		(cop3 init:)
		(cop5 init:)
		(cop6 init:)
		(badguy1 init: setScript: (sRandomScr new:))
		(badguy2 init: setScript: sRandomScr2)
		(badguy3 init:)
		(self setScript: sRunIt)
	)

	(method (dispose)
		(gGameMusic1 fade: 0 12 30 1)
		(super dispose:)
	)
)

(instance sFly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: (Random 0 3) setPri: 15 setCycle: Fwd)
				(switch (client loop:)
					(0
						(client posn: 329 30 setMotion: MoveTo -10 17 self)
					)
					(1
						(client posn: -10 17 setMotion: MoveTo 329 30 self)
					)
					(2
						(client posn: -10 95 setMotion: MoveTo 174 -15 self)
					)
					(3
						(client posn: 329 136 setMotion: MoveTo 198 -17 self)
					)
				)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance sLand of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0 (if (== register 4) 199 else 171))
				(= temp1 (if (== register 4) 116 else 124))
				(client
					setLoop: register
					setCycle: Fwd
					setMotion: MoveTo temp0 temp1 self
				)
			)
			(1
				(client setLoop: (+ register 2) setCycle: End self)
			)
			(2
				(client
					setLoop: (+ register 4)
					cycleSpeed: 10
					setCycle: RandCycle
				)
				(if (== client bird2)
					(bird3 init: setScript: (sLand new:) 0 5)
				)
			)
		)
	)
)

(instance sRunIt of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not local1) (== (murderer cel:) 4) (== (murderer loop:) 0))
			(gGameMusic2 number: 770 flags: 5 loop: 1 play: murderer)
			(= local1 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 0 local0 self)
			)
			(2
				(murderer setCycle: End self)
			)
			(3
				(if (< (++ local0) 4)
					(self changeState: 1)
				else
					(gMessager say: 1 0 0 4 self) ; "...well, she's got another think coming..."
				)
			)
			(4
				(murderer setCycle: CT 4 1 self)
			)
			(5
				(gGameMusic2 number: 770 flags: 5 loop: 1 play:)
				(murderer loop: 1 cel: 0 setCycle: End self)
			)
			(6
				(gMessager say: 1 0 0 5 self) ; "Do you hear me, Laura Bow? You'll pay for this..."
			)
			(7
				(gMessager say: 1 0 0 6 self) ; "...if it's the last thing I ever do!"
			)
			(8
				(gGameMusic1 number: 772 flags: 1 loop: 1 play: self)
			)
			(9
				(gCurRoom newRoom: (if (== global126 1) 775 else 785))
			)
		)
	)
)

(instance sRandomScr of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not local2) (== (client cel:) 4) (!= (client loop:) 5))
			(gGameMusic2 number: 770 flags: 5 loop: 1 play: badguy1)
			(= local2 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 30 120))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sRandomScr2 of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not local3) (== (client cel:) 4))
			(gGameMusic2 number: 770 flags: 5 loop: 1 play: badguy2)
			(= local3 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 30 120))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance bird of Actor
	(properties
		x -10
		y 17
		view 771
		loop 1
		signal 24576
		cycleSpeed 0
		moveSpeed 0
	)
)

(instance bird2 of Actor
	(properties
		x 329
		y 8
		view 771
		loop 4
		signal 24576
		cycleSpeed 0
		moveSpeed 0
	)
)

(instance bird3 of Actor
	(properties
		x 58
		y -18
		view 771
		loop 5
		signal 24576
		cycleSpeed 0
		moveSpeed 0
	)
)

(instance murderer of Prop
	(properties
		x 162
		y 176
		view 770
		cel 9
		cycleSpeed 15
	)

	(method (cue)
		(= local1 0)
		(super cue:)
	)
)

(instance cop2 of Prop
	(properties
		x 207
		y 45
		view 770
		loop 5
		cel 8
		cycleSpeed 15
	)
)

(instance cop3 of Prop
	(properties
		x 243
		y 49
		view 770
		loop 6
		cel 6
	)
)

(instance cop5 of Prop
	(properties
		x 275
		y 155
		view 770
		loop 6
		cel 5
	)
)

(instance cop6 of Prop
	(properties
		x 45
		y 151
		view 770
		loop 6
		cel 4
	)
)

(instance badguy1 of Prop
	(properties
		x 280
		y 131
		view 770
		loop 3
		cel 3
		cycleSpeed 15
	)

	(method (cue)
		(= local2 0)
		(super cue:)
	)
)

(instance badguy2 of Prop
	(properties
		x 247
		y 154
		view 770
		loop 2
		cycleSpeed 15
	)

	(method (cue)
		(= local3 0)
		(super cue:)
	)
)

(instance badguy3 of Prop
	(properties
		x 313
		y 136
		view 770
		loop 4
	)
)

(instance O_Riley of Narrator
	(properties
		name {O'Riley}
		x 10
		y 155
		modeless 1
		back 15
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

