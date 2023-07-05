;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 359)
(include sci.sh)
(use Main)
(use hotelBar)
(use Interface)
(use tahiti)
(use Follow)
(use Sight)
(use Motion)
(use Actor)
(use System)

(public
	iC 0
)

(instance iC of Act
	(properties
		y 115
		x -10
		view 711
	)

	(method (init)
		(super init: &rest)
		(self setCycle: copWalk setScript: iCS)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/cop,officer]>')
				(cond
					((IsOffScreen self))
					((Said 'look[<at]')
						(Print 359 0) ; "The officer is efficiently doing his job."
					)
					((Said 'talk')
						(Print 359 1) ; "He's busy, don't disturb him."
					)
				)
			)
		)
	)
)

(instance iCS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(client show:)
				(proc11_2 0)
				(if
					(and
						(or
							(< (gEgo distanceTo: (ScriptID 11 1)) 25) ; lush
							(< (Abs (- (gEgo y:) (iC y:))) 20)
						)
						(== (gEgo view:) 206)
					)
					(HandsOff)
					(gEgo
						setMotion:
							egoMoveTo
							((ScriptID 11 1) x:) ; lush
							(+ 20 ((ScriptID 11 1) y:)) ; lush
					)
				)
				(iC setMotion: copMoveTo 115 115 self)
			)
			(2
				(iC view: 811 loop: 3 setCycle: copEndLoop self)
			)
			(3
				(water init: setCycle: copEndLoop)
				(= seconds 5)
			)
			(4
				(water hide:)
				((ScriptID 11 3) init:) ; lSV
				((ScriptID 11 1) view: 811 loop: 5 cel: 0 posn: 145 114) ; lush
				(iC view: 711 setCycle: copWalk loop: 3)
				(= seconds 1)
			)
			(5
				(Print 359 2) ; "Crawling on the floor trying to regain her balance, Lisa says, "Hey, come on now! I ain't drunk, I'm just drinking!""
				((ScriptID 11 1) ; lush
					cycleSpeed: 1
					moveSpeed: 1
					setLoop: 0
					setCycle: lushWalk
					setMotion: lushMoveTo 60 114 self
				)
				(iC setMotion: copFollow (ScriptID 11 1) 30) ; lush
			)
			(6
				((ScriptID 11 1) ; lush
					loop: 1
					cycleSpeed: 1
					setCycle: copEndLoop self
				)
			)
			(7
				(iC setMotion: copMoveTo 50 115 self)
			)
			(8
				((ScriptID 11 1) ; lush
					loop: 2
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: lushWalk
					setMotion: lushFollow iC 5
				)
				(if (== (gEgo view:) 206)
					(HandsOn)
				)
				(iC setMotion: copMoveTo -10 115 self)
			)
			(9
				(= cycles 5)
			)
			(10
				((ScriptID 11 1) dispose:) ; lush
				(water dispose:)
				(iC dispose:)
				(tahiti flags: (& (tahiti flags:) $ffef))
			)
		)
	)
)

(instance water of Prop
	(properties
		y 108
		x 128
		view 811
		loop 4
		cycleSpeed 2
	)

	(method (delete)
		(super delete:)
		(DisposeScript 359)
	)
)

(instance copWalk of Walk
	(properties)
)

(instance egoMoveTo of MoveTo
	(properties)
)

(instance copMoveTo of MoveTo
	(properties)
)

(instance copEndLoop of End
	(properties)
)

(instance lushWalk of Walk
	(properties)
)

(instance lushMoveTo of MoveTo
	(properties)
)

(instance copFollow of Follow
	(properties)
)

(instance lushFollow of Follow
	(properties)
)

