;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	Room56 0
)

(local
	local0
	local1
	local2
	[local3 5]
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
)

(instance Room56 of Rm
	(properties
		picture 56
		style 16
		west 55
	)

	(method (init)
		(self setRegions: 600) ; MineReg
		(Load rsVIEW 516)
		(Load rsVIEW 283)
		(Load rsVIEW 286)
		(Load rsVIEW 287)
		(Load rsVIEW 4)
		(Load rsVIEW 518)
		(super init:)
		(= gIndoors 1)
		(gEgo view: 4 posn: 65 140 init:)
		(if ((Inv at: 1) ownedBy: gEgo) ; Diamond_Pouch
			(Load rsVIEW 288)
			(Load rsVIEW 281)
			(Load rsVIEW 523)
			((View new:) view: 287 loop: 3 cel: 0 posn: 118 69 addToPic:)
			((View new:) view: 286 loop: 4 cel: 0 posn: 70 71 addToPic:)
			((View new:) view: 283 loop: 1 cel: 0 posn: 211 100 addToPic:)
			((View new:) view: 516 loop: 0 cel: 0 posn: 234 119 addToPic:)
			((= local10 (Act new:))
				view: 287
				setLoop: 1
				illegalBits: 0
				posn: 118 53
				setCycle: Fwd
				init:
			)
			((= local8 (Act new:))
				view: 286
				illegalBits: 0
				posn: 70 55
				setLoop: 2
				setCycle: Fwd
				init:
			)
			((= local2 (Act new:))
				view: 283
				setLoop: 0
				illegalBits: 0
				posn: 211 90
				setCycle: Fwd
				init:
			)
			((= local1 (Act new:))
				view: 281
				loop: 4
				cel: 0
				illegalBits: 0
				posn: 233 130
				setPri: -1
				init:
				stopUpd:
			)
			((= local0 (Act new:))
				view: 281
				illegalBits: 0
				posn: (local1 x:) (- (local1 y:) 18)
				ignoreActors: 1
				init:
				setPri: (CoordPri (local1 y:))
				setLoop: 0
				setCycle: Fwd
			)
			(if (not (gEgo has: 3)) ; Lantern__unlit
				((= local17 (View new:))
					view: 523
					loop: 1
					posn: (- (local1 x:) 18) (- (local1 y:) 1)
					init:
					stopUpd:
				)
			)
			(local0 setScript: dwarvesMove)
		else
			(Load rsVIEW 280)
			((View new:) view: 283 loop: 1 cel: 0 posn: 82 71 addToPic:)
			((View new:) view: 286 loop: 4 cel: 0 posn: 83 122 addToPic:)
			((View new:) view: 287 loop: 2 cel: 0 posn: 109 121 addToPic:)
			((View new:) view: 516 loop: 0 cel: 0 posn: 99 73 addToPic:)
			((= local1 (View new:))
				view: 280
				loop: 4
				cel: 0
				posn: 211 99
				setPri: -1
				init:
				stopUpd:
			)
			((= local0 (Act new:))
				view: 280
				illegalBits: 0
				posn: (local1 x:) (- (local1 y:) 18)
				setLoop: 1
				ignoreActors: 1
				setPri: (CoordPri (local1 y:))
				setCycle: Fwd
				init:
			)
			((= local2 (Act new:))
				view: 283
				setLoop: 0
				illegalBits: 0
				posn: 82 61
				setCycle: Fwd
				init:
			)
			((= local8 (Act new:))
				view: 286
				setLoop: 2
				illegalBits: 0
				posn: 89 106
				setPri: 8
				setCycle: Fwd
				init:
			)
			((= local10 (Act new:))
				view: 287
				setLoop: 0
				illegalBits: 0
				posn: 110 107
				setPri: 8
				setCycle: Fwd
				init:
			)
			(local0 setScript: dwarvesMove)
		)
		((= local12 (Prop new:))
			view: 518
			cel: 2
			posn: 86 155
			setPri: 15
			cycleSpeed: 1
			setLoop: 3
			init:
			ignoreActors: 1
			stopUpd:
		)
		((= local13 (Prop new:))
			view: 518
			cel: 1
			posn: 261 118
			setPri: 15
			setLoop: 3
			init:
			ignoreActors: 1
			stopUpd:
		)
		((= local14 (Prop new:))
			view: 518
			posn: 212 119
			cycleSpeed: 1
			setPri: 9
			setLoop: 3
			init:
			ignoreActors: 1
			stopUpd:
		)
		((= local15 (Prop new:))
			view: 518
			cel: 3
			posn: 136 49
			setLoop: 3
			init:
			ignoreActors: 1
			stopUpd:
		)
		(local12 setScript: sparkle)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 55)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					(
						(or
							(Said 'give,return/pouch,diamond[/dwarf]')
							(Said 'give,return/dwarf/pouch,diamond')
						)
						(if
							(and
								(== ((Inv at: 1) owner:) gEgo) ; Diamond_Pouch
								(!= ((Inv at: 3) owner:) gEgo) ; Lantern__unlit
							)
							(if (< (gEgo distanceTo: local1) 20)
								(HandsOff)
								(gEgo setScript: handOff)
							else
								(Print 800 1) ; "You're not close enough."
							)
						else
							(Print 56 0) ; "The dwarf is not interested."
						)
					)
					(
						(or
							(Said 'look[<around][/!*]')
							(Said 'look[<around]/room')
							(Said 'look[<around]/mine[<diamond]')
						)
						(Print 56 1) ; "You see the busy little dwarfs hard at work within the diamond mine. The diamonds flash and sparkle from the earthen walls."
					)
					((Said 'look>')
						(cond
							((Said '/dwarf')
								(Print 56 2) ; "One dwarf appears to be idling by the diamond bucket."
							)
							((Said '/bucket')
								(Print 56 3) ; "You see a bucket brim full of sparkling diamonds."
							)
						)
					)
					(
						(and
							(< (gEgo distanceTo: local1) 30)
							(Said 'talk[/dwarf]')
						)
						(if (and (gEgo has: 1) (not (gEgo has: 3))) ; Diamond_Pouch, Lantern__unlit
							(answer1 cue:)
						else
							(Print 56 4) ; "You attempt to talk with the dwarf by the bucket again, but he only ignores you. You get the message."
						)
					)
					(
						(and
							(< (gEgo distanceTo: local1) 20)
							(or (Said 'kiss/dwarf') (Said 'kiss[/!*]'))
						)
						(Print 56 5) ; "You attempt to kiss the dwarf, but he seems embarrassed by it."
					)
					((Said 'get,rob/bucket')
						(Print 56 6) ; "The bucket is not yours, Rosella!"
					)
					((Said 'rob/lantern')
						(Print 56 7) ; "You were raised better than that!"
					)
				)
			)
		)
	)
)

(instance dwarvesMove of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch (= temp0 (Random 1 6))
					(1
						(local8 setCycle: End self)
					)
					(2
						(local0 loop: 3 cycleSpeed: 2 setCycle: End self)
						(local1 setLoop: 5)
					)
					(3
						(local10 setLoop: 1 setCycle: End self)
					)
					(4
						(local8 setCycle: End self)
					)
					(5
						(local10 setLoop: 1 setCycle: End self)
					)
					(6
						(local0 loop: 1 cycleSpeed: 0 setCycle: End self)
						(local1 setLoop: 5)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(local0 setMotion: 0 stopUpd:)
				(local8 setMotion: 0 stopUpd:)
				(local10 setMotion: 0 stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance sparkle of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch (Random 1 4)
					(1
						(local12 startUpd: setCycle: End self)
					)
					(2
						(local13 startUpd: setCycle: End self)
					)
					(3
						(local14 startUpd: setCycle: End self)
					)
					(4
						(local15 startUpd: setCycle: End self)
					)
				)
			)
			(1
				(local12 stopUpd:)
				(local13 stopUpd:)
				(local14 stopUpd:)
				(local15 stopUpd:)
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance answer1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 56 8) ; "You say "hello" to the small man next to the diamond bucket. He seems amazed to see you here. "Rosella!" he exclaims. "What're you doing here? Don't you know this ain't no place for a fine girl like yourself?" You don't agree with that, but you don't argue."
			)
			(1
				(Print 56 9) ; "Again, you speak to the dwarf by the diamond bucket. He peers up at you with mild agitation. "This ain't no place for a lady, Rosella!" he firmly states. "I don't wanna see you get hurt in here!""
			)
			(2
				(Print 56 10) ; "When you try speaking to the small man again, he only mutters under his breath in perturbation."
				(= state 1)
			)
		)
	)
)

(instance handOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dwarvesMove changeState: 2)
				(sparkle changeState: 2)
				(local10 dispose: delete:)
				(local8 dispose: delete:)
				(local15 dispose: delete:)
				(HandsOn)
				(local0 view: 288 loop: 0 setCycle: End)
				(Print 56 11 #at -1 15 #width 290 #font gSmallFont #draw) ; "Being an honest person, you offer the forgotten pouch of diamonds to the dwarf. His gruff exterior softens a bit. "Nah, you can keep it," he says. "We got plenty here. We also got an extra lantern we ain't using. Here, go ahead and take it." The dwarf's gruffness returns as he says, "Now, skedaddle on out of here!""
				(self cue:)
			)
			(1
				(local0 loop: 1 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(local0 hide:)
				(local17 dispose:)
				(local1
					view: 288
					loop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(gEgo get: 3) ; Lantern__unlit
				(gGame changeScore: 3)
			)
			(3
				((= local10 (Act new:))
					view: 287
					setLoop: 1
					illegalBits: 0
					posn: 118 53
					setCycle: Fwd
					init:
				)
				((= local8 (Act new:))
					view: 286
					illegalBits: 0
					posn: 70 55
					setLoop: 2
					setCycle: Fwd
					init:
				)
				((= local15 (Prop new:))
					view: 518
					cel: 3
					posn: 136 49
					setLoop: 3
					init:
					ignoreActors: 1
					stopUpd:
				)
				(dwarvesMove changeState: 0)
				(sparkle changeState: 0)
				(local0 view: 281 loop: 3 cel: 0 cycleSpeed: 0 show:)
				(local1 view: 281 loop: 5 cel: 0 stopUpd: ignoreActors: 0 init:)
				(= seconds 3)
			)
			(4
				(User canControl: 1 canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

