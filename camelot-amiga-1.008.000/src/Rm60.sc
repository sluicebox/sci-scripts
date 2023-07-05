;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm60 0
)

(local
	local0
)

(instance roomBlock of Blk
	(properties
		top 205
		bottom 220
		right 330
	)
)

(instance leftBlock of Blk
	(properties
		left -20
		bottom 220
		right -5
	)
)

(instance deadDog of PV
	(properties
		y 157
		x 107
		view 160
	)
)

(instance flies of Prop
	(properties
		y 159
		x 109
		view 160
		loop 1
		cycleSpeed 2
	)
)

(instance Rm60 of Rm
	(properties
		picture 60
	)

	(method (init)
		(super init:)
		(Load rsVIEW 160)
		(= global112 1)
		(if (IsFlag 20)
			(ClearFlag 20)
			(= global202 2)
		)
		(self setRegions: 152) ; Bazaar
		(gEgo
			view: 0
			posn: 310 165
			loop: 1
			init:
			observeBlocks: roomBlock leftBlock
			setMotion: MoveTo 295 165
		)
		(flies init: setCycle: Fwd)
		(gAddToPics add: deadDog)
		(gAddToPics doit:)
		(if (IsFlag 143)
			(ClearFlag 143)
			(= local0 1)
			(gCurRoom setScript: thiefPullsUpRope)
		)
	)

	(method (notify)
		(if local0
			(return 0)
		else
			(return -1)
		)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo x:) 310)
			(gCurRoom newRoom: 57)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(OnButton event 243 72 304 116)
					(Said 'look,read/apello,graffiti,mosaic')
					(Said 'ask//apello,graffiti,mosaic')
				)
				(Print 60 0) ; "Let us say simply that it is someone's crude idea of a joke."
			)
			(
				(or
					(Said 'look,read/latin,hebrew,greek,lettering')
					(Said 'read/wall')
					(OnButton event 61 89 84 103)
					(OnButton event 103 79 124 106)
					(OnButton event 128 125 160 135)
				)
				(Print 60 1) ; "It is only graffiti."
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((Said '<in/window')
						(Print 60 2) ; "It is completely dark and deserted."
					)
					((Said '<up')
						(Print 60 3) ; "The walls are far too high to jump over."
					)
					(
						(or
							(Said '<down')
							(Said '/dirt,street')
							(Said '//dirt,street')
						)
						(Print 60 4) ; "The alley is paved with stone, solidly set. The thief could not have escaped through the ground."
					)
					(
						(or
							(Said '/bar')
							(Said '//bar')
							(OnButton event 245 7 249 32)
						)
						(Print 60 5) ; "The bars are made of heavy iron."
					)
					(
						(or
							(Said 'look[<around,at][/!*][/!*]')
							(Said '/room,alley')
							(Said '//room,alley')
						)
						(Print 60 6) ; "It is a dead end alley with no doors and only two windows, one of which is bricked up and the other blocked by a heavy iron bar."
					)
					(
						(or
							(and
								(gCast contains: thief)
								(MouseClaimed thief event)
							)
							(Said '/bandit,man,boy')
							(Said '//bandit,man,boy')
						)
						(cond
							((gCurRoom script:)
								(Print 60 7) ; "The thief quickly pulls up his rope so you cannot follow!"
							)
							(local0
								(Print 60 8) ; "The thief has escaped."
							)
							(else
								(Print 60 9) ; "There is no sign of him at all."
							)
						)
					)
					((or (Said '/line') (Said '//line'))
						(cond
							((gCurRoom script:)
								(Print 60 7) ; "The thief quickly pulls up his rope so you cannot follow!"
							)
							(local0
								(Print 60 10) ; "The thief must have left behind a rope and climbed up it to escape."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					(
						(or
							(Said '/window')
							(Said '//window')
							(OnButton event 133 55 183 113)
							(OnButton event 225 7 271 41)
						)
						(Print 60 11) ; "The lower window is bricked up. Only a skinny man could squeeze into the upper window, if he had the means to reach it."
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 60 12) ; "The walls are old and deteriorating on the surface, but solid underneath. No doors, no sign of hidden openings, no way to scale or climb them."
					)
					((or (Said '/brick') (Said '//brick'))
						(Print 60 13) ; "They are very old, but quite solid."
					)
					(
						(or
							(Said '/puddle,water,liquid,urine,piss')
							(Said '//puddle,water,liquid,urine,piss')
							(OnButton event 37 150 82 163)
							(OnButton event 168 148 214 161)
						)
						(Print 60 14) ; "Judging from the smell, it is not something you want to step in."
					)
					(
						(or
							(Said '/dog,body')
							(Said '//dog,body')
							(OnButton event 87 146 127 158)
						)
						(Print 60 15) ; "A dog carcass is busily rotting."
					)
					((or (Said '/flea,bug') (Said '//flea,bug'))
						(Print 60 16) ; "They swarm over the remains of the dog."
					)
					((OnButton event 198 114 220 142)
						(Print 60 17) ; "I would prefer not to guess as to what that is."
					)
				)
			)
			((Said 'climb,climb,jump/wall,window')
				(Print 60 18) ; "The outer surface is crumbling. As for using the lower window as a foothold, you would not get far enough to do any good."
			)
			((Said 'bend,open/bar')
				(Print 60 19) ; "That is beyond your strength."
			)
			((Said 'cut,annihilate/bar')
				(Print 60 20) ; "Powerful though Excaliber is, it still has its limits. These bars would destroy the blade."
			)
			(
				(or
					(Said 'talk/merlin')
					(Said 'ask/advice')
					(Said 'ask[/merlin]/advice')
				)
				(if (not local0)
					(Print 60 21) ; "Had you followed him immediately, you might have at least had a chance to catch him. Now he could be anywhere."
				else
					(Print 60 22) ; "This thief was cunning enough to climb down a rope from the barred window, leave the rope hanging, then scurry back up the rope and escape."
				)
			)
			((Said 'draw/blade')
				(if (gCast contains: thief)
					(Print 60 23) ; "Even Excaliber could not stop this quick and elusive thief."
				else
					(Print 60 24) ; "The thief has escaped. And you would blunt your fine blade by hacking uselessly at these heavy iron bars."
				)
				(= global125 2)
			)
			((Said 'smell')
				(Print 60 25) ; "The combination of rotting dog and human excreta leaves much to be desired. Such as getting as far away from it as you can."
			)
			((Said '*/dog,body')
				(Print 60 26) ; "The dog is dead, putrid and full of disease, Arthur. Leave it be."
			)
			((Said '*/flea,bug')
				(Print 60 27) ; "They are busy with the rotting dog."
			)
			((or (Said 'capture,stop/bandit') (Said 'grab,get/line'))
				(if (gCast contains: thief)
					(Print 60 28) ; "The thief is too quick for you."
				else
					(Print 60 29) ; "The thief is gone."
				)
			)
			((Said 'talk,ask,greet')
				(if (gCast contains: thief)
					(Print 60 30) ; "The thief is too busy escaping."
				else
					(Print 60 31) ; "There is no one here."
				)
			)
		)
	)
)

(instance thief of Prop
	(properties
		y 33
		x 251
		view 160
		loop 3
		priority 11
		signal 16400
	)

	(method (doit)
		(super doit:)
		(switch cel
			(0
				(rope posn: 249 35)
			)
			(3
				(rope posn: 245 40)
			)
			(else
				(rope posn: 246 42)
			)
		)
	)
)

(instance rope of Prop
	(properties
		y 36
		x 243
		view 160
		loop 2
		priority 11
		signal 16400
	)
)

(instance thiefPullsUpRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(thief init:)
				(rope init:)
				(= seconds 1)
			)
			(1
				(thief cycleSpeed: 2 setCycle: Fwd)
				(rope cycleSpeed: 4 setCycle: End self)
			)
			(2
				(= seconds 1)
			)
			(3
				(thief setLoop: 4 setCel: 0 setPri: 1 setCycle: End self)
			)
			(4
				(thief dispose:)
				(rope dispose:)
				(client setScript: 0)
			)
		)
	)
)

