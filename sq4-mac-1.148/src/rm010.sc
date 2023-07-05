;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm010 0
)

(local
	local0
	[local1 5]
)

(instance rm010 of SQRoom
	(properties
		picture 10
	)

	(method (init &tmp [temp0 50])
		(Load rsVIEW 11)
		(Load rsVIEW 10)
		(LoadMany rsSOUND 5 6 7 8 9 10 11 12 112 113 880)
		(blip init:)
		(super init:)
		(self setScript: planetScript setRegions: 707) ; intro
	)
)

(instance planetScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== (self state:) 1) (== (gLongSong prevSignal:) 10))
			(gLongSong prevSignal: 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 13 loop: 1 vol: 127 playBed:)
				(= cycles 2)
			)
			(1
				(= local0
					(proc0_12
						{During the descent to this cosmic\ncanteen he is unaware of the interest that\nhas been generated regarding his fate.}
						67
						1
						35
						70
						318
						28
						global137
						29
						global129
						30
						1
						33
						310
					)
				)
			)
			(2
				(Display 10 0 dsRESTOREPIXELS local0)
				(= cycles 5)
			)
			(3
				(FX init: number: 880 loop: -1 play:)
				(planet init: setCycle: End self)
			)
			(4
				(FX stop:)
				(planet stopUpd:)
				(= cycles 20)
			)
			(5
				(FX number: 5 loop: 1 play:)
				(DrawCel 10 1 0 108 139 global131)
				(= cycles 20)
			)
			(6
				(mag init: setCycle: End self)
			)
			(7
				(mag stopUpd:)
				(= cycles 20)
			)
			(8
				(FX number: 6 play:)
				(DrawCel 10 1 1 108 148 global131)
				(= cycles 20)
			)
			(9
				(rog init: setCycle: End self)
			)
			(10
				(rog stopUpd:)
				(= cycles 20)
			)
			(11
				(FX number: 7 play:)
				(grid init:)
				(= cycles 20)
			)
			(12
				(FX number: 8 play:)
				(grid setCycle: End self)
			)
			(13
				(grid setCel: 0 setLoop: 2 setCycle: End self)
			)
			(14
				(gLongSong number: 10 loop: 1 vol: 127 playBed:)
				(grid setLoop: 3 setCycle: Fwd)
				(= cycles 20)
			)
			(15
				(FX number: 11 play:)
				(dx1 init:)
				(dx2 init:)
				(dx3 init:)
				(dy1 init:)
				(dy2 init:)
				(dy3 init:)
				(= cycles 25)
			)
			(16
				(blip number: 113 loop: -1 play:)
				(dx1 setCycle: Fwd)
				(dx2 setCycle: Fwd)
				(dx3 setCycle: Fwd)
				(dy1 setCycle: Fwd)
				(dy2 setCycle: Fwd)
				(dy3 setCycle: Fwd)
				(= cycles 8)
			)
			(17
				(dx1 setCycle: CT 2 1)
				(dy1 setCycle: CT 1 1)
				(= cycles 12)
			)
			(18
				(dx2 setCycle: CT 5 1)
				(dy2 setCycle: CT 4 1)
				(= cycles 14)
			)
			(19
				(dx3 setCycle: CT 9 1)
				(dy3 setCycle: CT 2 1)
				(= cycles 10)
			)
			(20
				(blip stop: dispose:)
				(= cycles 5)
			)
			(21
				(gLongSong number: 12 loop: 1 vol: 127 playBed:)
				(= cycles 2)
			)
			(22
				(grid stopUpd:)
				(dx1 stopUpd:)
				(dy1 stopUpd:)
				(dx2 stopUpd:)
				(dy2 stopUpd:)
				(dx3 stopUpd:)
				(dy3 stopUpd:)
				(loc init: setCel: (mod register 2))
				(if (mod register 2)
					(FX loop: 1 play:)
				)
				(++ register)
				(= cycles 6)
			)
			(23
				(if (< register 8)
					(-= state 2)
					(= cycles 1)
				else
					(= local0
						(proc0_12
							{"We have confirmation of\nhis position, Master."}
							67
							1
							2
							70
							178
							28
							global136
							29
							global129
							30
							1
						)
					)
					(= seconds 7)
				)
			)
			(24
				(proc0_12 local0)
				(= cycles 10)
			)
			(25
				(= local0
					(proc0_12
						{"Off to Magmetheus with you then! It is time for Wilco to meet the fate which I have crafted for him."}
						67
						140
						2
						70
						178
						28
						global140
						29
						global129
						30
						1
					)
				)
				(= seconds 7)
			)
			(26
				(proc0_12 local0)
				(Animate (gCast elements:) 0)
				(gCurRoom newRoom: 15)
			)
		)
	)
)

(instance planet of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 11 setCel: 0 ignoreActors: 1 posn: 157 94 setPri: 4)
	)
)

(instance grid of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 11
			setLoop: 1
			setCel: 0
			ignoreActors: 1
			posn: 140 79
			setPri: 5
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== (self loop:) 2) (== (self cel:) 0))
			(FX number: 9 play:)
		)
	)
)

(instance dx1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 10 setLoop: 0 setCel: 0 ignoreActors: 1 posn: 78 99)
	)
)

(instance dx2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 10 setLoop: 0 setCel: 0 ignoreActors: 1 posn: 86 99)
	)
)

(instance dx3 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 10 setLoop: 0 setCel: 0 ignoreActors: 1 posn: 94 99)
	)
)

(instance dy1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 10 setLoop: 0 setCel: 0 ignoreActors: 1 posn: 151 45)
	)
)

(instance dy2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 10 setLoop: 0 setCel: 0 ignoreActors: 1 posn: 159 45)
	)
)

(instance dy3 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 10 setLoop: 0 setCel: 0 ignoreActors: 1 posn: 167 45)
	)
)

(instance mag of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 10 setLoop: 2 setCel: 0 ignoreActors: 1 posn: 155 146)
	)

	(method (doit)
		(super doit:)
		(if (< (self cel:) 9)
			(blip play:)
		)
	)
)

(instance rog of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 10
			setLoop: 4
			setCel: 0
			ignoreActors: 1
			posn: 155 155
			cycleSpeed: 1
		)
	)

	(method (doit)
		(super doit:)
		(if (< (self cel:) 9)
			(blip play:)
		)
	)
)

(instance loc of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 10
			setLoop: 3
			setCel: 0
			ignoreActors: 1
			posn: 157 169
			cycleSpeed: 12
		)
	)
)

(instance FX of Sound
	(properties)
)

(instance blip of Sound
	(properties
		number 112
	)
)

