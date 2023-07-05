;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	Room54 0
)

(synonyms
	(sink counter)
	(cottage room)
)

(local
	local0
	local1
	local2
	[local3 8]
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
)

(instance Room54 of Rm
	(properties
		picture 54
		style 16
	)

	(method (init)
		(Load rsVIEW 677)
		(Load rsVIEW 678)
		(Load rsVIEW 630)
		(Load rsVIEW 290)
		(Load rsVIEW 500)
		(Load rsVIEW 533)
		(self setRegions: 601) ; regDwarfHouse
		(gGSound play: -15536)
		(if (== gPrevRoomNum 654)
			(gCurRoom style: 6)
		)
		(super init:)
		((View new:) view: 533 loop: 1 cel: 0 posn: 295 106 setPri: 9 addToPic:)
		((= local12 (Act new:))
			view: 290
			loop: 3
			illegalBits: 0
			ignoreActors: 0
			setCycle: Walk
			setScript: bounceBitchScript
			init:
			hide:
		)
		(= gIndoors 1)
		(NormalEgo)
		(gEgo view: 4 observeControl: 4 setStep: 4 2)
		(cond
			((== gPrevRoomNum 53)
				(if (== gDwarfEscortOut 1)
					(local12 posn: 253 86 setMotion: Follow gEgo show:)
					(gEgo posn: 205 104 loop: 1 init:)
					(bounceBitchScript changeState: 6)
				else
					(local12 posn: 147 1194 show:)
					(gEgo posn: 222 87 init:)
					(if global115
						(Load rsVIEW 61)
						(Load rsVIEW 62)
						(gEgo setScript: cleanKitchen)
					)
				)
			)
			((== gPrevRoomNum 654)
				(gEgo posn: 270 135 loop: 2 init:)
			)
			(else
				(local12 posn: 147 1194 show:)
				(gEgo posn: 147 157 loop: 3 init:)
				(= global115 0)
			)
		)
		(if (not global177)
			(for ((= local11 7)) (>= local11 0) ((-- local11))
				((= [local3 local11] (View new:))
					view: 500
					loop: 1
					cel: 2
					ignoreActors: 1
					setPri: 12
					posn:
						(switch local11
							(0 189)
							(1 193)
							(2 218)
							(3 228)
							(4 240)
							(5 262)
							(6 270)
							(7 295)
						)
						(switch local11
							(0 136)
							(1 133)
							(2 133)
							(3 136)
							(4 133)
							(5 136)
							(6 133)
							(7 136)
						)
					init:
					stopUpd:
				)
			)
		else
			((= [local3 0] (View new:))
				view: 677
				posn: 78 102
				loop: 3
				cel: 0
				init:
				stopUpd:
			)
		)
		(if (== ((gInventory at: 1) owner:) 54) ; Diamond_Pouch
			((= local24 (View new:))
				view: 500
				ignoreActors: 1
				loop: 0
				cel: 0
				setPri: 12
				posn: 236 134
				init:
				stopUpd:
			)
		)
		(if (not global102)
			((= local14 (View new:))
				view: 677
				loop: 0
				cel: 0
				posn: 100 98
				init:
				stopUpd:
			)
			((= local15 (View new:))
				view: 677
				loop: 0
				cel: 1
				posn: 110 98
				init:
				stopUpd:
			)
			((= local16 (View new:))
				view: 677
				loop: 0
				cel: 2
				posn: 120 98
				init:
				stopUpd:
			)
			((= local17 (View new:))
				view: 677
				loop: 1
				cel: 0
				posn: 130 98
				init:
				stopUpd:
			)
			((= local18 (View new:))
				view: 677
				loop: 1
				cel: 1
				posn: 140 98
				init:
				stopUpd:
			)
			((= local19 (View new:))
				view: 677
				loop: 1
				cel: 2
				posn: 150 98
				init:
				stopUpd:
			)
			((= local20 (View new:))
				view: 678
				loop: 0
				cel: 0
				posn: 160 98
				init:
				stopUpd:
			)
			((= local21 (View new:))
				view: 678
				loop: 0
				cel: 1
				posn: 170 98
				init:
				stopUpd:
			)
			((= local22 (View new:))
				view: 678
				loop: 0
				cel: 2
				posn: 180 98
				init:
				stopUpd:
			)
			((= local23 (View new:))
				view: 677
				loop: 0
				cel: 3
				posn: 107 96
				init:
				stopUpd:
			)
		)
		(= global176 0)
		((= local0 (Prop new:))
			view: 630
			posn: 83 124
			cycleSpeed: 0
			setCycle: Fwd
			init:
		)
		(if (not global223)
			(local0 addToPic:)
		)
		((= local1 (Prop new:))
			view: 677
			setLoop: 2
			cel: 3
			setPri: 9
			posn: 56 137
			ignoreActors: 1
			init:
			stopUpd:
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 22)
			((ScriptID 601) keep: 0) ; regDwarfHouse
		)
		(= global189 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (and (== local25 0) (== (gEgo script:) 0))
			(cond
				((& (gEgo onControl:) $0020)
					(gCurRoom newRoom: 53)
				)
				((& (gEgo onControl:) $0200)
					(gEgo setScript: useSteps)
					(useSteps changeState: 1)
				)
				((& (gEgo onControl:) $1000)
					(gEgo setScript: useSteps)
					(useSteps changeState: 4)
				)
				((& (gEgo onControl:) $0040)
					(gEgo illegalBits: -32768 ignoreActors: 0 loop: 2)
					(gCurRoom newRoom: 22)
				)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((or (Said 'is<how<time') (Said '[!*]/time'))
				(Print 54 0) ; "The clock is broken."
			)
			((Said 'open,(look<in)/cabinet')
				(Print 54 1) ; "There is nothing to interest you in the cupboards."
			)
			((Said 'close/cabinet')
				(if (not global102)
					(Print 54 2) ; "This house needs more than that!"
				else
					(Print 54 3) ; "It is already closed."
				)
			)
			((Said 'open/door,closet,pantry')
				(cond
					((== (local1 cel:) 0)
						(Print 54 4) ; "It is already open."
					)
					((gEgo inRect: 40 137 70 150)
						(local1 setScript: doorOpen)
					)
					(else
						(Print 800 1) ; "You're not close enough."
					)
				)
			)
			((Said 'close/door,closet,pantry')
				(cond
					((> (local1 cel:) 0)
						(Print 54 3) ; "It is already closed."
					)
					((gEgo inRect: 0 137 70 145)
						(local1 setScript: doorClose)
					)
					(else
						(Print 800 1) ; "You're not close enough."
					)
				)
			)
			((Said 'sit')
				(Print 54 5) ; "Not now."
			)
			((Said 'clean[/cottage]')
				(if (== gDwarfEscortOut 1)
					(Print 54 5) ; "Not now."
					(return)
				)
				(cond
					((& (gEgo onControl:) $0004)
						(Print 54 6) ; "Not while you're in here."
					)
					((== global102 0)
						(gEgo setScript: startClean)
					)
					((not global177)
						(gEgo setScript: cleanTable)
					)
					(else
						(Print 54 7) ; "The house is nice and clean now."
					)
				)
			)
			((Said 'clean,scrub/table,dish')
				(cond
					((and global102 (not global177))
						(gEgo setScript: cleanTable)
					)
					((and global102 global177)
						(Print 54 8) ; "Twice was enough."
					)
					(else
						(Print 54 2) ; "This house needs more than that!"
					)
				)
			)
			((Said 'clean,do,scrub,sweep,dust[/dish,dirt,furniture]')
				(if global102
					(Print 54 9) ; "The room is nice and clean now."
				else
					(Print 54 2) ; "This house needs more than that!"
				)
			)
			((Said 'eat,drink,eat/soup')
				(if (not global176)
					(Print 54 5) ; "Not now."
				else
					(Print 54 10) ; "Haven't you had enough already!!"
				)
			)
			((Said 'get>')
				(cond
					((Said '/dish[<dirty]')
						(if (or (not global102) (not global177))
							(Print 54 11) ; "You don't want dirty dishes!"
						else
							(Print 54 12) ; "You don't need them."
						)
					)
					((Said '/broom')
						(if (& (gEgo onControl: 1) $0004)
							(Print 54 13) ; "You don't need the broom."
						else
							(Print 54 14) ; "What broom?"
						)
					)
					((Said '/caldron')
						(Print 54 15) ; "The pot doesn't belong to you."
					)
					((Said '/bowl')
						(Print 54 16) ; "You don't need the soup bowls."
					)
					((Said '/soup')
						(if global176
							(Print 54 17) ; "You're not hungry now."
						else
							(Print 54 18) ; "The soup doesn't belong to you."
						)
					)
					((Said '/pouch,diamond')
						(cond
							((gEgo has: 1) ; Diamond_Pouch
								(event claimed: 0)
							)
							((== ((gInventory at: 1) owner:) gCurRoomNum) ; Diamond_Pouch
								(if (gEgo inRect: 200 140 276 164)
									(gEgo get: 1) ; Diamond_Pouch
									(= global182 1)
									(gGame changeScore: 2)
									(local24 dispose:)
								else
									(Print 800 1) ; "You're not close enough."
								)
							)
							(else
								(Print 54 19) ; "What pouch?!"
							)
						)
					)
				)
			)
			((Said 'look>')
				(cond
					((and (== global176 1) (Said '/soup'))
						(Print 54 20) ; "The soup is delicious!"
					)
					((and ((Inv at: 1) ownedBy: 54) (Said '/pouch,diamond')) ; Diamond_Pouch
						(Print 54 21) ; "There is a blue pouch in the center of the table."
					)
					((Said '/window')
						(if (gEgo inRect: 124 117 197 130)
							(Print 54 22) ; "You can see the forest out the window."
						else
							(Print 800 1) ; "You're not close enough."
						)
					)
					((Said '/mantel,mantel')
						(if
							(and
								(gCast contains: [local3 0])
								(== ([local3 0] view:) 677)
							)
							(Print 54 23) ; "Clean soup bowls are set on the mantel above the fireplace."
						else
							(Print 54 24) ; "There is nothing on top of the mantel."
						)
					)
					((Said '<under/table')
						(Print 54 25) ; "There is nothing of interest under the table."
					)
					((Said '/table')
						(if global177
							(Print 54 26) ; "You see a long, wooden table."
							(if (== ((gInventory at: 1) owner:) 54) ; Diamond_Pouch
								(Print 54 27) ; "You also notice a blue pouch."
							)
						else
							(Print 54 28) ; "You see a long, wooden table. Empty soup bowls are left on it."
							(if (== ((gInventory at: 1) owner:) gCurRoomNum) ; Diamond_Pouch
								(Print 54 27) ; "You also notice a blue pouch."
							)
						)
					)
					((Said '/stair')
						(Print 54 29) ; "The narrow stairs lead up to the bedroom."
					)
					((Said '/cabinet')
						(Print 54 30) ; "You see many cupboards."
					)
					((Said '<in/cabinet')
						(Print 54 1) ; "There is nothing to interest you in the cupboards."
					)
					((Said '/wall')
						(Print 54 31) ; "There is nothing of importance on the walls."
					)
					((or (Said '/dirt') (Said '<down'))
						(Print 54 32) ; "There is nothing interesting on the floor."
					)
					((Said '/bowl')
						(if global177
							(Print 54 33) ; "Clean soup bowls are set on the mantle above the fireplace."
						else
							(Print 54 34) ; "Empty soup bowls are left on the table."
						)
					)
					((Said '/caldron,soup')
						(Print 54 35) ; "You see a pot of soup bubbling over a cheery fire."
					)
					((Said '/fire,fireplace')
						(Print 54 36) ; "A cheery fire heats a bubbling pot of soup in the fireplace."
					)
					((Said '/carpet')
						(Print 54 37) ; "A rag rug covers the floor."
					)
					((Said '/sink')
						(if global102
							(Print 54 38) ; "The sink is clean and empty."
						else
							(Print 54 39) ; "There are dirty dishes in the sink."
						)
					)
					((Said '/dish[<dirty]')
						(if (or (not global102) (not global177))
							(Print 54 40) ; "The dishes are dirty."
						else
							(Print 54 41) ; "The dishes have been washed and put away."
						)
					)
					((Said '/clock[<cuckoo]')
						(Print 54 42) ; "This clock has seen better days. The cuckoo has flown away."
					)
					((Said '/time')
						(Print 54 43) ; "This clock is broken."
					)
					((Said '<in/closet')
						(cond
							((& (gEgo onControl: 1) $0004)
								(Print 54 44) ; "The closet contains only an old broom."
							)
							((> (local1 cel:) 0)
								(Print 54 45) ; "The closet is closed."
							)
							(else
								(Print 800 1) ; "You're not close enough."
							)
						)
					)
					((Said '/closet')
						(if (& (gEgo onControl: 1) $0004)
							(Print 54 46) ; "There's nothing much in the closet except for an old broom."
						else
							(Print 54 47) ; "You see a closet door."
						)
					)
					((Said '/broom')
						(if (& (gEgo onControl: 1) $0004)
							(Print 54 48) ; "You see an old broom."
						else
							(Print 54 49) ; "You can't see any brooms from here."
						)
					)
					((Said '[<around][/cottage,kitchen]')
						(Print 54 50) ; "This is the main room of the Seven Dwarfs' cozy tree house."
						(if (== global102 0)
							(Print 54 51) ; "What a mess it is!"
						)
					)
				)
			)
		)
	)
)

(instance startClean of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local25 1)
				(= global204 0)
				(= global205 1)
				(= global115 1)
				(gEgo illegalBits: 0 setAvoider: Avoid)
				(Notify 601 1)
				(gEgo setMotion: MoveTo 135 (gEgo y:) self)
			)
			(1
				(gEgo setMotion: MoveTo 135 130 self)
			)
			(2
				(gEgo setMotion: MoveTo 192 123 self)
			)
			(3
				(gEgo setLoop: 0 setMotion: MoveTo 232 88 self)
			)
			(4
				(gEgo setMotion: MoveTo 243 90 self)
			)
			(5
				(gCurRoom newRoom: 53)
			)
		)
	)
)

(instance cleanKitchen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local25 1)
				(gEgo
					illegalBits: 0
					setAvoider: Avoid
					loop: 1
					setMotion: MoveTo 194 123 self
				)
			)
			(1
				(cleanTable cue:)
			)
			(2
				(gEgo setLoop: -1 setMotion: MoveTo 103 120 self)
			)
			(3
				(local14 dispose:)
				(gEgo setMotion: MoveTo 110 (gEgo y:) self)
			)
			(4
				(local15 dispose:)
				(local23 dispose:)
				(gEgo setMotion: MoveTo 120 (gEgo y:) self)
			)
			(5
				(local16 dispose:)
				(gEgo setMotion: MoveTo 130 (gEgo y:) self)
			)
			(6
				(local17 dispose:)
				(gEgo setMotion: MoveTo 140 (gEgo y:) self)
			)
			(7
				(local18 dispose:)
				(gEgo setMotion: MoveTo 150 (gEgo y:) self)
			)
			(8
				(local19 dispose:)
				(gEgo setMotion: MoveTo 160 (gEgo y:) self)
			)
			(9
				(local20 dispose:)
				(gEgo setMotion: MoveTo 170 (gEgo y:) self)
			)
			(10
				(local21 dispose:)
				(local22 dispose:)
				(gEgo setMotion: MoveTo 180 (gEgo y:) self)
			)
			(11
				(gEgo setMotion: MoveTo 160 (gEgo y:) self)
			)
			(12
				(dishDust init:)
				(gEgo view: 62 loop: 3 setCycle: Fwd)
				(= seconds 5)
			)
			(13
				(dishDust dispose:)
				(gEgo view: 4 setLoop: -1 setMotion: MoveTo 83 134 self)
			)
			(14
				((= [local3 0] (View new:))
					view: 677
					posn: 78 102
					loop: 3
					cel: 0
					init:
				)
				(local1 setPri: 6 ignoreActors: 1 setCycle: Beg)
				(gEgo setMotion: MoveTo 65 140 self)
			)
			(15
				(gEgo setMotion: MoveTo 45 140 self)
			)
			(16
				(gEgo view: 61 setMotion: MoveTo 150 145 self)
			)
			(17
				(sweepDust init:)
				(gEgo setLoop: 2 setMotion: MoveTo 170 122 self)
			)
			(18
				(gEgo setMotion: MoveTo 120 155 self)
			)
			(19
				(gEgo setMotion: MoveTo 45 140 self)
			)
			(20
				(sweepDust dispose:)
				(local1 setCycle: End setPri: 6)
				(gEgo
					view: 4
					setLoop: -1
					illegalBits: -32768
					setMotion: MoveTo 140 155 self
				)
			)
			(21
				(gEgo setMotion: MoveTo 150 125 self)
			)
			(22
				(= global204 0)
				(= local25 0)
				(= global115 0)
				(Notify 601 0)
				(= global205 1)
				(= global102 1)
				(gEgo loop: 2 forceUpd:)
				(local1 dispose:)
				(gGame changeScore: 5)
				(gCurRoom newRoom: 654)
			)
		)
	)
)

(instance dishDust of Prop
	(properties
		view 678
	)

	(method (init)
		(super init:)
		(self
			loop: 1
			setCycle: Fwd
			ignoreActors:
			posn: (gEgo x:) (- (gEgo y:) 20)
			setPri: (- (gEgo priority:) 1)
		)
	)

	(method (doit)
		(super doit:)
		(self
			posn: (gEgo x:) (- (gEgo y:) 20)
			setPri: (- (gEgo priority:) 1)
		)
	)
)

(instance sweepDust of Prop
	(properties
		view 678
	)

	(method (init)
		(super init:)
		(self
			loop: 2
			setCycle: Fwd
			ignoreActors: 1
			posn: (gEgo x:) (gEgo y:)
			setPri: (gEgo priority:)
		)
	)

	(method (doit)
		(super doit:)
		(self posn: (gEgo x:) (gEgo y:) setPri: (gEgo priority:))
	)
)

(instance cleanTable of Script
	(properties)

	(method (init param1)
		(Load rsVIEW 63)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local25 1)
				(if (not global115)
					(= global115 1)
					(Notify 601 1)
				)
				(gEgo illegalBits: 0 setAvoider: Avoid setCycle: Walk)
				(if (> (gEgo y:) 145)
					(gEgo setMotion: MoveTo 135 159 self)
				else
					(gEgo setMotion: MoveTo 135 150 self)
				)
			)
			(1
				(= local11 7)
				(gEgo setMotion: MoveTo 290 (gEgo y:) self)
			)
			(2
				([local3 local11] dispose:)
				(gEgo
					view: 63
					setLoop: (if (> (gEgo y:) 151) 3 else 2)
					setMotion: MoveTo (+ (* local11 10) 190) (gEgo y:) self
				)
			)
			(3
				(if (> local11 0)
					(-- local11)
					(= state 1)
					(self cue:)
				else
					(gEgo
						view: 4
						setLoop: -1
						setMotion: MoveTo 135 (gEgo y:) self
					)
				)
			)
			(4
				(if (not global102)
					(cleanKitchen cue:)
				else
					(gEgo setMotion: MoveTo 150 120 self)
				)
			)
			(5
				(dishDust init:)
				(gEgo view: 62 loop: 3 setCycle: Fwd)
				(= seconds 5)
			)
			(6
				(dishDust dispose:)
				(gEgo view: 4 setLoop: -1 setMotion: MoveTo 83 134 self)
			)
			(7
				((= [local3 0] (View new:))
					view: 677
					posn: 78 102
					loop: 3
					cel: 0
					init:
				)
				(gEgo
					setAvoider: 0
					setCycle: Walk
					setMotion: MoveTo 123 134 self
				)
			)
			(8
				(= global177 1)
				(= local25 0)
				(= global115 0)
				(Notify 601 0)
				(NormalEgo)
				(gEgo observeControl: 4)
				(HandsOn)
				(= global189 1)
				(client setScript: 0)
				(Print 54 52) ; "Phew! I hope that's the last of it!"
			)
		)
	)
)

(instance doorOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 64 146 self)
			)
			(1
				(gEgo loop: 1)
				(local1 setCycle: Beg self)
			)
			(2
				(gEgo ignoreControl: 4)
				(HandsOn)
			)
		)
	)
)

(instance doorClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 64 144 self)
			)
			(1
				(gEgo loop: 1)
				(local1 setCycle: End self)
			)
			(2
				(HandsOn)
				(gEgo observeControl: 4)
			)
		)
	)
)

(instance useSteps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(= local25 1)
				(gEgo ignoreControl: -32768 setMotion: MoveTo 232 88 self)
			)
			(2
				(gEgo setMotion: MoveTo 243 90 self)
			)
			(3
				(HandsOn)
				(= global189 1)
				(gEgo observeControl: -32768 setScript: 0)
				(gCurRoom newRoom: 53)
			)
			(4
				(HandsOff)
				(= local25 1)
				(gEgo ignoreControl: -32768 setMotion: MoveTo 192 123 self)
			)
			(5
				(HandsOn)
				(= local25 0)
				(= global189 1)
				(gEgo observeControl: -32768 setScript: 0)
			)
		)
	)
)

(instance bounceBitchScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(if
					(or
						global115
						gDwarfEscortOut
						global204
						global102
						(> (gEgo y:) 155)
						(< (gEgo y:) 119)
					)
					(-- state)
					(= seconds 5)
				else
					(Print 54 53) ; "Oh, oh! You've been caught trespassing! You are unceremoniously ordered out by an angry dwarf."
					(= gDwarfEscortOut 1)
					(HandsOff)
					(local12
						posn: 140 221
						setMotion: MoveTo 140 160 self
						setAvoider: Avoid
					)
				)
			)
			(2
				(local12 setMotion: MoveTo 110 160 self)
			)
			(3
				(local12 loop: 0 stopUpd:)
				(= local25 1)
				(gEgo illegalBits: 0 setMotion: MoveTo 140 (gEgo y:) self)
			)
			(4
				(gEgo setMotion: MoveTo 140 162 self)
			)
			(5
				(= global102 2)
				(= gDwarfEscortOut 0)
				(NormalEgo)
				(gEgo observeControl: 4)
				(HandsOn)
				(User canInput: 0)
				(gCurRoom newRoom: 22)
			)
			(6
				(= seconds 0)
				(HandsOff)
				(= local25 1)
				(gEgo setMotion: MoveTo 192 123 self)
			)
			(7
				(gEgo setMotion: MoveTo 140 131 self)
				(= state 3)
			)
		)
	)
)

