;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use LoadMany)
(use Timer)
(use RegionPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	streetRgn 0
	wanderTalker 1
)

(local
	[local0 20]
	[local20 20]
	[local40 20]
	[local60 38] = [105 11 106 2 117 4 119 5 120 6 121 7 122 8 123 9 128 10 824 1 825 12 827 13 828 14 830 16 832 17 833 18 835 19 836 20 834 21]
	local98
	local99
	local100
	[local101 5] = [0 1 2 3 4]
	[local106 49] = [32767 220 160 152 355 152 32767 230 -35 152 355 152 32767 240 -35 152 355 152 32767 250 -35 152 190 152 32767 250 190 152 -35 152 32767 240 355 152 -35 152 32767 230 355 152 -35 152 32767 220 355 152 160 152 -32768]
	[local155 63] = [32767 240 160 125 -35 125 32767 230 355 125 230 125 -35 130 32767 220 355 130 109 130 32767 220 109 130 355 130 32767 230 -35 130 230 125 355 125 32767 240 -35 125 355 125 32767 250 -35 125 93 125 212 135 32767 250 212 135 93 125 -35 125 32767 240 355 125 160 125 -32768]
	[local218 57] = [32767 250 160 129 -35 129 32767 240 355 129 119 129 -35 168 32767 230 355 168 58 168 -35 146 32767 220 355 146 214 181 32767 220 214 181 355 146 32767 230 -35 146 58 168 355 168 32767 240 -35 168 119 129 355 129 32767 250 -35 129 160 129 -32768]
)

(instance streetRgn of Rgn
	(properties)

	(method (init)
		(= [local101 0] sSitDown)
		(= [local101 1] sLieDown)
		(= [local101 2] sWag)
		(= [local101 3] sPant)
		(= [local101 4] sLickTummy)
		(if (or (IsFlag 71) (not (OneOf gPrevRoomNum 220 230 240 250)))
			(if (IsFlag 71)
				(ClearFlag 71)
			)
			(= local98 (* (Random 0 18) 2))
			(= local99 (Random 30 300))
			(Message msgGET 90 25 0 0 (+ 1 (/ local98 2)) @local0)
			(wander1
				view: [local60 local98]
				name: @local0
				noun: [local60 (+ local98 1)]
			)
			(if (OneOf (wander1 view:) 827 828 830 106 832)
				(wander1 xStep: 6)
			else
				(wander1 xStep: 3)
			)
			(wanderTimer2 setReal: wanderTimer2 local99)
		)
		(if (> (gGame detailLevel:) (wander1 detailLevel:))
			(wander1
				init:
				loop: 0
				setCycle: Walk
				setMotion: wander1Path wander1
			)
			(if (wander1 findX:)
				(wander1Path findNextRoom:)
			)
		)
		(if (> (gGame detailLevel:) (wander2 detailLevel:))
			(wander2 init: loop: 0 setCycle: Walk)
		)
		(if (> (gGame detailLevel:) (wander3 detailLevel:))
			(wander3 init: loop: 0 setCycle: Walk)
		)
		(if (== (wander2 view:) 1843)
			(wander2 z: 1000)
		else
			(wander2 setMotion: wander2Path wander2)
			(if (wander2 findX:)
				(wander2Path findNextRoom:)
			)
		)
		(if (== (wander3 view:) 1843)
			(wander3 z: 1000)
		else
			(wander3 setMotion: wander3Path wander3)
			(if (wander3 findX:)
				(wander3Path findNextRoom:)
			)
		)
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 220 230 240 250))
		(= initialized 0)
	)

	(method (dispose)
		(LoadMany 0 984)
		(gTimers
			delete:
				wanderTimer2
				wanderTimer3
				soundTimer1
				soundTimer2
				soundTimer3
		)
		(super dispose:)
	)
)

(class Wanderer of Actor
	(properties
		z 1000
		modNum 90
		view 1843
		signal 4096
		scaleSignal 4
		detailLevel 2
	)

	(method (init)
		(super init:)
		(self setLoop: -1)
		(if (not (OneOf view 829 830))
			(self setScale: Scaler 100 76 162 110)
		)
		(if (and (== gCurRoomNum 230) (== gPrevRoomNum 500))
			(= noun 24)
		)
	)

	(method (doVerb)
		(wanderTalker name: name)
		(super doVerb: &rest)
	)

	(method (cue)
		(super cue:)
		(if (OneOf view 117 832 833 824 827 835)
			(self setScript: sSitDown 0 loop)
		)
	)

	(method (findX)
		(cond
			((and (< nsLeft 0) (== (gEgo edgeHit:) 4))
				(if (< (mover x:) 0)
					(if (< nsRight 0)
						(= x (- 320 (CelWide view loop cel)))
						(return 1)
					else
						(+= x 320)
						(return 1)
					)
				else
					(+= x 320)
					(mover findPrevRoom:)
					(return 0)
				)
			)
			(
				(and
					(< nsLeft 0)
					(== (gEgo edgeHit:) 2)
					(== (mover currentRoom:) gCurRoomNum)
				)
				(= x (CelWide view loop cel))
				(return 0)
			)
			((and (> nsRight 320) (== (gEgo edgeHit:) 2))
				(if (> (mover x:) 320)
					(if (> nsLeft 320)
						(= x (CelWide view loop cel))
						(return 1)
					else
						(-= x 320)
						(return 1)
					)
				else
					(-= x 320)
					(mover findPrevRoom:)
					(return 0)
				)
			)
			(
				(and
					(> nsRight 320)
					(== (gEgo edgeHit:) 4)
					(== (mover currentRoom:) gCurRoomNum)
				)
				(= x (- 320 (CelWide view loop cel)))
				(return 0)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance wander1 of Wanderer
	(properties)
)

(instance wander2 of Wanderer
	(properties)
)

(instance wander3 of Wanderer
	(properties)
)

(class WandererPath of RegionPath
	(properties
		theRegion 90
	)

	(method (init)
		(super init: &rest)
		(= endType
			(if (OneOf (client view:) 117 832 833 824 827 835) 0 else 1)
		)
	)

	(method (findNextRoom &tmp temp0 temp1)
		(= temp0 (client x:))
		(= temp1 (client y:))
		(while (!= (self at: value) 32767)
			(self nextValue: 1)
		)
		(self nextRoom: next:)
		(client posn: temp0 temp1)
	)

	(method (findPrevRoom &tmp temp0 temp1 temp2 temp3)
		(= temp0 (client x:))
		(= temp1 (client y:))
		(= temp2 x)
		(= temp3 y)
		(while (!= (self at: value) 32767)
			(-= value 4)
			(self nextValue: 1)
		)
		(-= value 4)
		(self nextValue: 1)
		(while (!= (self at: value) 32767)
			(-= value 4)
			(self nextValue: 1)
		)
		(self nextRoom: x: temp2 y: temp3)
		(client posn: temp0 temp1)
	)

	(method (curRoomCheck &tmp temp0 temp1)
		(= temp0 (client z:))
		(if (== currentRoom gCurRoomNum)
			(client
				z:
					(if (>= temp0 1000)
						(- temp0 1000)
					else
						temp0
					)
				illegalBits: theOldBits
				signal: theOldSignal
			)
			(switch (client noun:)
				(4
					(= temp1 2117)
				)
				(5
					(= temp1 2117)
				)
				(6
					(= temp1 2120)
				)
				(7
					(= temp1 2121)
				)
				(8
					(= temp1 2122)
				)
				(9
					(= temp1 2123)
				)
				(else
					(= temp1 0)
				)
			)
			(if temp1
				(wander1Sound number: temp1)
				(soundTimer1 setReal: soundTimer1 (Random 5 10))
			)
		else
			(client
				z:
					(if (< temp0 1000)
						(+ temp0 1000)
					else
						temp0
					)
				illegalBits: 0
				ignoreActors: 1
				ignoreHorizon:
			)
			(gTimers delete: soundTimer1)
		)
	)
)

(instance wander1Path of WandererPath
	(properties)

	(method (at param1)
		(return [local106 param1])
	)
)

(instance wander2Path of WandererPath
	(properties)

	(method (at param1)
		(return [local155 param1])
	)
)

(instance wander3Path of WandererPath
	(properties)

	(method (at param1)
		(return [local218 param1])
	)
)

(instance wanderTimer2 of Timer
	(properties)

	(method (setReal)
		(streetRgn timer: self)
		(super setReal: &rest)
	)

	(method (cue)
		(if (== gCurRoomNum 240)
			(self setReal: self local99)
		else
			(while
				(OneOf
					(= local98 (* (Random 0 18) 2))
					830
					(wander1 view:)
					(wander3 view:)
				)
			)
			(= local99 (Random 30 300))
			(Message msgGET 90 25 0 0 (+ 1 (/ local98 2)) @local20)
			(wander2
				view: [local60 local98]
				name: @local20
				noun: [local60 (+ local98 1)]
			)
			(if (OneOf (wander2 view:) 827 828 830 106 832)
				(wander2 xStep: 6)
			else
				(wander2 xStep: 3)
			)
			(wanderTimer3 setReal: wanderTimer3 local99)
			(if (> (gGame detailLevel:) (wander2 detailLevel:))
				(wander2
					init:
					loop: 1
					setCycle: Walk
					setMotion: wander2Path wander2
				)
			)
		)
	)
)

(instance wanderTimer3 of Timer
	(properties)

	(method (setReal)
		(streetRgn timer: self)
		(super setReal: &rest)
	)

	(method (cue)
		(if (== gCurRoomNum 250)
			(self setReal: self local99)
		else
			(while
				(OneOf
					(= local98 (* (Random 0 18) 2))
					830
					(wander1 view:)
					(wander2 view:)
				)
			)
			(Message msgGET 90 25 0 0 (+ 1 (/ local98 2)) @local40)
			(wander3
				view: [local60 local98]
				name: @local40
				noun: [local60 (+ local98 1)]
			)
			(if (OneOf (wander3 view:) 827 828 830 106 832)
				(wander3 xStep: 6)
			else
				(wander3 xStep: 3)
			)
			(if (> (gGame detailLevel:) (wander3 detailLevel:))
				(wander3
					init:
					loop: 0
					setCycle: Walk
					setMotion: wander3Path wander3
				)
			)
		)
	)
)

(instance soundTimer1 of Timer
	(properties)

	(method (setReal)
		(streetRgn timer: self)
		(super setReal: &rest)
	)

	(method (cue)
		(if (< (wander1 z:) 1000)
			(wander1Sound play:)
		)
		(self setReal: self (Random 5 10))
	)
)

(instance soundTimer2 of Timer
	(properties)

	(method (setReal)
		(streetRgn timer: self)
		(super setReal: &rest)
	)

	(method (cue)
		(if (< (wander2 z:) 1000)
			(wander2Sound play:)
		)
		(self setReal: self (Random 5 10))
	)
)

(instance soundTimer3 of Timer
	(properties)

	(method (setReal)
		(streetRgn timer: self)
		(super setReal: &rest)
	)

	(method (cue)
		(if (< (wander3 z:) 1000)
			(wander3Sound play:)
		)
		(self setReal: self (Random 5 10))
	)
)

(instance sSitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (OneOf (client view:) 117 832 827 835)
					(client setLoop: (+ 2 register))
				else
					(client setLoop: 2)
				)
				(client cel: 0 setCycle: End self)
			)
			(1
				(= local100 (Random 1 4))
				(if (== (client view:) 117)
					(client setScript: [local101 local100] 0 register)
				else
					(= cycles 2)
				)
			)
			(2
				(if (OneOf (client view:) 827 835 832)
					(client setLoop: (+ (client loop:) 2))
				else
					(client setLoop: 3)
				)
				(client cel: 0 setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sLieDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: (+ 4 register) cel: 0 setCycle: End self)
			)
			(1
				(if (< (client z:) 1000)
					(gTimers delete: soundTimer1 soundTimer2 soundTimer3)
					(dogSound number: 2118 loop: 1 play: self)
				)
			)
			(2
				(= seconds 12)
			)
			(3
				(self changeState: 1)
			)
		)
	)
)

(instance sWag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: (+ 8 register) cel: 0 setCycle: Fwd)
				(= ticks (Random 60 120))
			)
			(1
				(= local100 (Random 1 4))
				(client setScript: [local101 local100] 0 register)
			)
		)
	)
)

(instance sPant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: (+ 10 register) cel: 0 setCycle: End self)
			)
			(1
				(= ticks (Random 60 120))
				(= local100 (Random 1 4))
				(client setScript: [local101 local100] 0 register)
			)
		)
	)
)

(instance sLickTummy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: (+ 12 register) cel: 0 setCycle: End self)
			)
			(1
				(client setLoop: (+ 14 register) cel: 0 setCycle: Fwd)
				(if (and (OneOf (client noun:) 4 5) (< (client z:) 1000))
					(gTimers delete: soundTimer1 soundTimer2 soundTimer3)
					(dogSound number: 2119 loop: -1 play:)
				)
				(= ticks (Random 60 120))
			)
			(2
				(= local100 (Random 1 4))
				(client setScript: [local101 local100] 0 register)
				(dogSound stop:)
			)
		)
	)
)

(instance wanderTalker of Narrator
	(properties)

	(method (init)
		(= font gUserFont)
		(= showTitle 1)
		(= back global134)
		(super init: &rest)
	)
)

(instance wander1Sound of FPSound
	(properties
		flags 1
	)
)

(instance wander2Sound of FPSound
	(properties
		flags 1
	)
)

(instance wander3Sound of FPSound
	(properties
		flags 1
	)
)

(instance dogSound of FPSound
	(properties
		flags 1
		loop -1
	)
)

