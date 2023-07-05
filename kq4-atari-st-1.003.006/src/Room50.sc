;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room50 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance theSelection of Sound
	(properties)
)

(instance Room50 of Rm
	(properties
		picture 50
		style 16
	)

	(method (init)
		(ogressChaseMusic init:)
		(ogressCatchMusic init:)
		(Load rsVIEW 247)
		(Load rsVIEW 245)
		(Load rsVIEW 48)
		(Load rsVIEW 540)
		(Load rsVIEW 647)
		(self setRegions: 602) ; regOgreHouse
		(super init:)
		(if gNight
			((View new:) view: 647 loop: 2 posn: 244 95 addToPic:)
		)
		((= local2 (Prop new:))
			view: 540
			loop: 0
			cel: 1
			posn: 160 86
			init:
			cycleSpeed: 2
			setCycle: Fwd
		)
		((= local3 (Prop new:))
			view: 540
			loop: 2
			posn: 227 82
			init:
			setCycle: Fwd
		)
		((= local4 (Prop new:))
			view: 540
			loop: 2
			posn: 266 89
			init:
			setCycle: Fwd
		)
		((= local0 (Act new:)) setScript: ogressChase)
		(gEgo posn: 77 132 view: 2 setStep: 3 2 init:)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(self newRoom: 49)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '<under/table')
							(Print 50 0) ; "There is nothing of interest under the table."
						)
						((Said '/table')
							(Print 50 1) ; "That is the carving table."
						)
						((Said '/stove')
							(Print 50 2) ; "Something TERRIBLE is cooking on the stove! You have NO desire to know what it is!"
						)
						((Said '/window')
							(Print 50 3) ; "You see the forest out the window."
						)
						((Said '/buck')
							(Print 50 4) ; "Poor thing!"
						)
						((Said '/caldron')
							(Print 50 5) ; "Whatever's in the pot smells AWFUL!"
						)
						((Said '/wall')
							(Print 50 6) ; "There is nothing of importance on the walls."
						)
						((or (Said '/dirt') (Said '<down'))
							(Print 50 7) ; "There is nothing interesting on the floor."
						)
						((Said '/giantess')
							(Print 50 8) ; "You don't want to mess with this ogress. You'd better get out of here!"
						)
						((Said '[<around,at][/room,cottage,kitchen]')
							(Print 50 9) ; "You smell something HORRIBLE cooking on the stove in the ogre's kitchen! As a matter of fact, you get the feeling that this is NOT a safe place to be!"
						)
					)
				)
				((or (Said 'talk/giantess') (Said 'talk[/!*]'))
					(if (== (ogressChase state:) 0)
						(Print 50 10) ; "Now you blew it! You foolishly spoke to the ogress, and drew her attention toward you. Now she's headed your way!"
						(ogressChase seconds: 0 changeState: 2)
					else
						(Print 50 11) ; "This is no time for conversation!"
					)
				)
				((Said 'get,rob/buck')
					(Print 50 12) ; "You are not interested in the deer."
				)
				((Said 'kill/giantess')
					(Print 50 13) ; "You have no way of killing a giant ogress!"
				)
				((Said 'get,capture/giantess')
					(Print 50 14) ; "That's ridiculous."
				)
				((Said 'help,save/buck')
					(Print 50 15) ; "It's too late. You can't help the deer now."
				)
				((and (Said 'give>') (= temp0 (gInventory saidMe:)))
					(if (temp0 ownedBy: gEgo)
						(Print 50 16) ; "You don't want to get that close to the ogress!"
					else
						(event claimed: 1)
						(Print 50 17) ; "It's not yours to give."
					)
				)
			)
		)
	)
)

(instance ogressChase of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (< (gEgo distanceTo: client) 25) (== state 0))
			(= seconds 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 247
					loop: 0
					posn: 173 121
					cycleSpeed: 3
					setCycle: Fwd
					init:
				)
				(= seconds 5)
			)
			(1
				(Print 50 18) ; "The ogress sees you! You'd better run as she'd like to have YOU for dinner!"
				(self cue:)
			)
			(2
				(theSelection number: 10 loop: 1 play:)
				(= global167 1)
				(local0
					view: 245
					cycleSpeed: 0
					illegalBits: 0
					setCycle: Walk
					setAvoider: Avoid
					setMotion: Chase gEgo 15 self
				)
			)
			(3
				(theSelection number: 11 loop: 1 play:)
				(gEgo hide:)
				(local0 view: 48 setCycle: Walk setMotion: MoveTo 173 125 self)
			)
			(4
				(Print 50 19 #at -1 20) ; "Poor Rosella! Looks like you'll join the deer in the stew pot tonight."
				(= seconds 5)
			)
			(5
				(= gDeathFlag 1)
			)
		)
	)
)

(instance ogressChaseMusic of Sound
	(properties
		number 10
	)
)

(instance ogressCatchMusic of Sound
	(properties
		number 11
	)
)

(instance playMusic of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch theSelection
					(10
						(ogressChaseMusic play: self)
					)
					(11
						(ogressCatchMusic play: self)
					)
				)
			)
			(1
				(if (!= theSelection 11)
					(= state -1)
					(self cue:)
				)
			)
		)
	)
)

