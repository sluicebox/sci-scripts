;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 58)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Path)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room58 0
)

(synonyms
	(board floorboard)
	(bible book)
	(room chapel)
)

(local
	local0
	local1
	local2
	local3
	[local4 7] = [117 113 232 115 216 92 -32768]
	[local11 7] = [238 115 117 113 115 94 -32768]
	local18
)

(instance Room58 of Rm
	(properties
		picture 58
	)

	(method (init)
		(super init:)
		(Load rsVIEW 50)
		(LoadMany rsSOUND 43 44)
		(gAddToPics add: statueRight statueLeft eachElementDo: #init doit:)
		(Organ loop: -1 priority: -1 play:)
		(self setFeatures: Pew1 Pew2 Window1 Window2 Altar StainedGlass)
		(if (and (not gWilburCorpseRoomNum) (>= gAct 2))
			(if (and (!= gAct 6) (== (Random 1 2) 1))
				(= gWilburCorpseRoomNum 58)
			else
				(= gWilburCorpseRoomNum 69)
			)
		)
		(Door
			cel: (and global133 (- (NumCels Door) 1))
			ignoreActors: 1
			stopUpd:
			init:
		)
		(if (or (== global155 11) (>= gAct 2))
			(if gDetailLevel
				(flame1 setPri: 7 setCycle: Fwd init:)
				(flame2 setPri: 7 setCycle: Fwd init:)
				(flame3 setPri: 7 setCycle: Fwd init:)
			else
				(flame1 setPri: 7 init: stopUpd:)
				(flame2 setPri: 7 init: stopUpd:)
				(flame3 setPri: 7 init: stopUpd:)
			)
			(lamp cel: 0)
		)
		(lamp init: stopUpd:)
		(board
			cel:
				(if (== global134 2)
					(= local1 8)
					(- (NumCels board) 1)
				else
					(= local1 0)
				)
			setPri: (if (== global134 2) 9 else 2)
			ignoreActors: 1
			init:
		)
		(switch gAct
			(1
				(LoadMany rsSCRIPT 985 983)
				(LoadMany rsVIEW 440 441)
				(if (or (== global155 10) (== global155 11))
					(Jeeves view: 441 illegalBits: 0 init:)
					(HandsOff)
					(Jeeves setScript: lightCandles)
					(Door cel: (- (NumCels Door) 1))
				)
			)
			(6
				(= gWilburCorpseRoomNum 69)
				(self setRegions: 279) ; pray
			)
		)
		(if
			(and
				(== gWilburCorpseRoomNum 58)
				(not (& gCorpseFlags $0002)) ; Wilbur
				(not (& gCorpseFlags $0040)) ; Lillian
			)
			(|= gCorpseFlags $0002) ; Wilbur
			(self setRegions: 256) ; Dwilb
		)
		(gEgo
			view: 0
			x: (if global133 115 else 226)
			y: (if global133 87 else 154)
			illegalBits: (| (| local1 (<< (^ global133 $0001) $0004)) $8000)
			init:
		)
		(if global133
			(HandsOff)
			(self setScript: myDoor)
		)
		(self setFeatures: statueRight statueLeft lamp)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 58 0) ; "This is the old plantation chapel. Above the pulpit you see a beautiful, stained glass window."
		)
		(if (and (& (gEgo onControl: 1) $0004) (not local3) (not global133))
			(= local3 1)
			(HandsOff)
			(self setScript: myDoor)
		)
		(if (& (gEgo onControl: 1) $0008)
			(if (and (== global134 0) (not local0) (not script))
				(Creak loop: 1 play:)
				(gEgo setMotion: 0)
				(Wait 60)
				(= local0 1)
				(Print 58 1) ; "You are momentarily startled when a floorboard sags slightly as you step upon it."
			)
		else
			(= local0 0)
		)
		(if (& (gEgo onControl: 1) $0002)
			(= global133 0)
			(gCurRoom newRoom: 9)
		)
		(if
			(and
				(== (gEgo view:) 24)
				(== (gEgo loop:) 3)
				(> (gEgo cel:) 1)
				(< (gEgo cel:) 4)
			)
			(board cel: (- 3 (gEgo cel:)))
		)
		(if (and (== [gCycleTimers 2] 700) (== gAct 1))
			(if script
				(= [gCycleTimers 2] 710)
			else
				(= local18 1)
				(HandsOff)
				(self setScript: lightCandles)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(DisposeScript 983)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (gCast contains: Jeeves)
			(= global155 11)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 5])
		(if (event claimed:)
			(return)
		)
		(if
			(or
				(& (gEgo onControl: 0) $0001)
				(& (gEgo onControl: 0) $0008)
			)
			(= temp1 1)
		else
			(= temp1 0)
		)
		(if (== (event type:) evSAID)
			(cond
				((or (Said '/board>') (Said '//board>'))
					(= temp0 2)
					(if global219
						(if (not global224)
							(return)
						)
						(= temp0 (!= global171 7))
					)
					(cond
						((Said 'look')
							(if (== global134 2)
								(Print 58 2) ; "The floorboard has been pried open exposing a small niche in the chapel floor."
							else
								(Print 58 3) ; "You notice some sagging floorboards near the pulpit."
							)
						)
						(
							(and
								(!= temp0 1)
								(or
									(Said
										'(break,lift,force)[<(open,up)]//crowbar'
									)
									(Said '(break,lift,force)<use<crowbar')
									(Said 'open<use<crowbar')
									(Said 'open//crowbar')
								)
							)
							(if (gEgo has: 7) ; crowbar
								(cond
									((== global134 2)
										(AlreadyOpen) ; "It is already open."
									)
									(temp1
										(self setScript: PryBoard)
									)
									(else
										(Print 58 4) ; "Why don't you get closer?"
									)
								)
							else
								(self setScript: tryBoard)
							)
						)
						(
							(and
								(== temp0 2)
								(Said 'get,open,move,pull,break,lift,force')
							)
							(if (== global134 0)
								(if temp1
									(self setScript: tryBoard)
								else
									(Print 58 4) ; "Why don't you get closer?"
								)
							else
								(AlreadyOpen) ; "It is already open."
							)
						)
						(
							(or
								(Said '(break,lift,force)[<(open,up)]//poker')
								(Said '(break,lift,force)<use<poker')
								(Said 'open//poker')
							)
							(if (gEgo has: 6) ; poker
								(Print 58 5) ; "The poker won't fit in the crack."
							)
						)
						(
							(or
								(Said '(break,lift,force)[<(open,up)]//cane')
								(Said '(break,lift,force)<use<cane')
								(Said 'open//cane')
							)
							(if (gEgo has: 21) ; cane
								(Print 58 6) ; "The cane won't fit in the crack."
							)
						)
						((Said 'press,close')
							(cond
								((< global134 2)
									(AlreadyClosed) ; "It is already closed."
								)
								(temp1
									(self setScript: CloseBoard)
								)
								(else
									(Print 58 4) ; "Why don't you get closer?"
								)
							)
						)
					)
				)
				((Said '/bible>')
					(cond
						((!= global134 2)
							(NotHere) ; "You don't see it here."
							(event claimed: 1)
						)
						((Said 'get,open,read,look')
							(if (not local2)
								(= local2 1)
								(SetFlag 14)
								(self setScript: GetBible)
							)
						)
						((Said 'drop,(attach[<(back,down)])')
							(if local2
								(self setScript: CloseBoard)
							else
								(DontHave) ; "You don't have it."
							)
						)
					)
				)
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 58 0) ; "This is the old plantation chapel. Above the pulpit you see a beautiful, stained glass window."
						)
						((Said '/cross')
							(Print 58 7) ; "The cross is merely a part of the stained glass window."
						)
						((Said '/cemetery')
							(Print 58 8) ; "The cemetery is out back."
						)
						((or (Said '/ceiling') (Said '<up'))
							(Print 58 9) ; "You look up at the ceiling but see nothing of interest."
						)
						((Said '/wall')
							(Print 58 10) ; "You look carefully at the walls around you, but see nothing special about them."
						)
						((or (Said '/platform,dirt') (Said '<down'))
							(Print 58 3) ; "You notice some sagging floorboards near the pulpit."
						)
						((Said '/eyehole')
							(if (== global134 2)
								(if (< (gEgo distanceTo: board) 40)
									(Print 58 11) ; "Inside the niche, you see an old leather-bound Bible."
								else
									(NotClose) ; "You're not close enough."
								)
							else
								(NotHere) ; "You don't see it here."
							)
						)
					)
				)
				((Said 'pray[/altar]')
					(if temp1
						(self setScript: pray)
					else
						(Print 58 12) ; "Why don't you get \1bcloser to the pulpit?"
					)
				)
			)
		)
	)
)

(instance lightCandles of Script
	(properties)

	(method (doit)
		(if (or (& (Jeeves onControl: 0) $0001) (& (Jeeves onControl: 0) $0040))
			(Jeeves setPri: -1)
		else
			(Jeeves setPri: 2)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(== [gCycleTimers 2] 699)
				(if local18
					(Door startUpd: cycleSpeed: 3 setCycle: End self)
					(Jeeves
						view: 440
						setPri: 2
						setCycle: Walk
						posn: 115 86
						init:
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if local18
					(Jeeves
						setPri: -1
						setMotion: PathIn self
						setAvoider: (Avoid new:)
					)
					(if (gEgo inRect: 203 86 272 117)
						(gEgo setMotion: MoveTo 245 120)
					)
				else
					(HandsOff)
					(= cycles 1)
				)
			)
			(2
				(Jeeves view: 441 cel: 0 illegalBits: 0 setCycle: CT 3 1 self)
			)
			(3
				(flame1 setPri: 7 setCycle: Fwd init:)
				(= cycles 17)
			)
			(4
				(Jeeves cel: 4)
				(flame2 setPri: 7 setCycle: Fwd init:)
				(= cycles 17)
			)
			(5
				(Jeeves cel: 5)
				(flame3 setPri: 7 setCycle: Fwd init:)
				(lamp cel: 0 forceUpd:)
				(= cycles 7)
			)
			(6
				(Jeeves setCycle: End self)
			)
			(7
				(Jeeves
					view: 440
					setCycle: Walk
					illegalBits: -32768
					setMotion: PathOut self
				)
				(if (gEgo inRect: 106 77 137 113)
					(gEgo setMotion: MoveTo 117 120)
				)
			)
			(8
				(if (== (Door cel:) 0)
					(Door startUpd: cycleSpeed: 3 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(9
				(Jeeves setMotion: MoveTo 115 86 self)
			)
			(10
				(Door startUpd: cycleSpeed: 3 setCycle: Beg self)
			)
			(11
				(Door stopUpd:)
				(HandsOn)
				(= global155 12)
				(Jeeves dispose:)
			)
		)
	)
)

(instance myDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if global133
					(= state 4)
					(self cue:)
				else
					(gEgo setMotion: MoveTo 115 100 self)
				)
			)
			(2
				(gEgo illegalBits: -32768 loop: 3)
				(Door startUpd: cycleSpeed: 3 setCycle: End self)
				(mySound number: 43 priority: 5 loop: 1 play:)
			)
			(3
				(gEgo setMotion: MoveTo 115 87 self)
			)
			(4
				(HandsOn)
				(= global133 1)
				(gCurRoom setScript: 0 newRoom: 9)
			)
			(5
				(gEgo setMotion: MoveTo 115 100 self)
			)
			(6
				(gEgo illegalBits: (| local1 $8010))
				(Door startUpd: setCycle: Beg self)
				(mySound number: 44 loop: 1 priority: 5 play:)
			)
			(7
				(= global133 0)
				(if (not (Jeeves script:))
					(HandsOn)
				)
				(Door stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance PryBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 1)
				(= global134 1)
				(HandsOff)
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 101 133 self
				)
			)
			(1
				(gEgo
					view: 50
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(gEgo loop: 2 cel: 0 posn: 98 133 setCycle: End self)
			)
			(3
				(gEgo loop: 4 cel: 0 setCycle: Fwd)
				(= cycles 8)
			)
			(4
				(board setPri: 9 setCycle: End self)
				(= global134 2)
			)
			(5
				(Print 58 2) ; "The floorboard has been pried open exposing a small niche in the chapel floor."
				(gEgo loop: 2)
				(gEgo
					cel: (- (NumCels gEgo) 1)
					illegalBits: (| (gEgo illegalBits:) $0008)
					setCycle: Beg self
				)
			)
			(6
				(gEgo
					view: 0
					loop: 1
					cycleSpeed: 0
					setAvoider: 0
					setCycle: Walk
				)
				(= cycles 1)
			)
			(7
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance GetBible of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: (Avoid new:) setMotion: MoveTo 84 138 self)
			)
			(1
				(gEgo view: 17 cel: 0 loop: 1 setCycle: End self)
			)
			(2
				(gEgo
					view: 24
					cel: 0
					loop: 0
					posn: 83 138
					setAvoider: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(gEgo cel: 0 loop: 1 cycleSpeed: 2 setCycle: End self)
			)
			(4
				(Print 58 13) ; "After removing the brittle old Bible from the opening in the floorboards, you carefully open it. Written inside the front cover you see..."
				(Print 58 14 #font 4 #width 270) ; "Francois Pierre Crouton Born - 1787 Passed away - 1832   Married Claudette Marie Tourte - 1815 Claudette Marie Crouton Born - 1796 Passed away - 1856 Thomas Simon Crouton Born - 1816 Claude Francois Crouton Born - 1819   Thomas wed Mary Frances O'Neil - 1848 Mary Frances Crouton Born - 1827 William Thomas Crouton Born - 1851 Passed away - 1851 Sarah Marie Crouton Born - 1854"
				(gEgo cel: 0 loop: 2 setCycle: Fwd)
				(= cycles 30)
			)
			(5
				(gEgo loop: 0 setCycle: 0)
				(gEgo cel: (- (NumCels gEgo) 1))
				(Print 58 15) ; "Upon further searching through the old Bible you notice a strange notation on the last page. It says..."
				(Print 58 16 #font 4) ; "Sarah,    Our end is near. The bell will ring solemnly on our final night, and then will sound no more. Sir Lancelot will forever salute us. Do not weep for us, my child. We will watch over you. We love you. Do not ever forget.      Mama"
				(User canInput: 1)
				(self setScript: CloseBoard)
				(= cycles 1)
			)
			(6
				(if script
					(= state 5)
					(= cycles 1)
				else
					(client setScript: 0)
				)
			)
		)
	)
)

(instance CloseBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not local2)
					(gEgo
						setAvoider: (Avoid new:)
						setMotion: MoveTo 84 138 self
					)
				else
					(gEgo loop: 0)
					(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
					(= state 1)
				)
			)
			(1
				(gEgo view: 17 cel: 0 loop: 1 setCycle: End self)
			)
			(2
				(gEgo
					view: 24
					cel: 0
					loop: 3
					posn: 83 138
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(if (!= (board cel:) 0)
					(= state 2)
				else
					(gEgo
						view: 0
						loop: 1
						illegalBits: (& (gEgo illegalBits:) $fff7)
						setAvoider: 0
						cycleSpeed: 0
						setCycle: Walk
					)
					(board setPri: 2)
				)
				(= cycles 1)
			)
			(4
				(if local2
					(Print 58 17) ; "With a sad heart, you tenderly close the fragile Bible and reverently place it back in its hiding place under the chapel's floorboards."
				else
					(Print 58 18) ; "Except for some marks in the dust, the floor looks undisturbed."
				)
				(HandsOn)
				(= global134 (= local2 0))
				(client setScript: 0)
			)
		)
	)
)

(instance tryBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: (Avoid new:) setMotion: MoveTo 84 138 self)
			)
			(1
				(gEgo view: 17 cel: 0 loop: 1 setCycle: End self)
			)
			(2
				(gEgo
					view: 24
					cel: 0
					loop: 0
					posn: 83 138
					setAvoider: 0
					cycleSpeed: 2
					setCycle: CT 3 1 self
				)
			)
			(3
				(Print 58 19 #dispose) ; "Although the floorboard is loose you can't seem to budge it with your bare hands."
				(gEgo loop: 4 cycleSpeed: 4 setCycle: Fwd)
				(= cycles 21)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(cls)
				(gEgo
					view: 17
					cel: 3
					loop: 1
					cycleSpeed: 2
					setCycle: Beg self
				)
			)
			(6
				(gEgo view: 0 loop: 1 cycleSpeed: 0 setCycle: Walk)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance pray of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 104 128 self
				)
			)
			(1
				(gEgo
					view: 59
					cel: 0
					loop: 0
					posn: 103 128
					setAvoider: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(Print 58 20) ; "Suddenly feeling pious, you kneel at the pulpit and pray."
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 0 loop: 1 cycleSpeed: 0 setCycle: Walk)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance statueLeft of RPicView
	(properties
		y 48
		x 147
		view 158
		loop 3
		priority 1
	)

	(method (handleEvent event)
		(cond
			((Said 'get/monument')
				(Print 58 21) ; "The statues belong here."
			)
			((or (MousedOn self event 3) (Said 'look/monument,alcove'))
				(event claimed: 1)
				(Print 58 22) ; "Each alcove shelters a small statue of a religious figure."
			)
		)
	)
)

(instance statueRight of RPicView
	(properties
		y 56
		x 257
		view 158
		loop 3
		cel 1
		priority 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 58 22) ; "Each alcove shelters a small statue of a religious figure."
		)
	)
)

(instance lamp of Prop
	(properties
		y 52
		x 203
		view 158
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(cond
			((Said 'get/candle')
				(Print 58 23) ; "The candles are firmly afixed to the wall."
			)
			((Said 'ignite/candle')
				(Print 58 24) ; "You don't need to do that."
			)
			((or (MousedOn self event 3) (Said 'look/candle'))
				(event claimed: 1)
				(Print 58 25) ; "You notice candles on the wall."
			)
		)
	)
)

(instance Door of Prop
	(properties
		y 82
		x 131
		view 158
		priority 4
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/door<back'))
				(event claimed: 1)
				(Print 58 26) ; "The back door of the chapel leads into the small cemetery."
			)
			((Said 'look/door<front')
				(Print 58 27) ; "The chapel door leads out front."
			)
			((Said 'look/door')
				(Print 58 28) ; "You see a front door and a back door."
			)
		)
	)
)

(instance board of Prop
	(properties
		y 135
		x 53
		view 158
		loop 4
	)
)

(instance flame1 of Prop
	(properties
		y 35
		x 199
		view 158
		loop 2
	)
)

(instance flame2 of Prop
	(properties
		y 34
		x 204
		view 158
		loop 2
		cel 1
	)
)

(instance flame3 of Prop
	(properties
		y 36
		x 209
		view 158
		loop 2
		cel 1
	)
)

(instance Jeeves of Act
	(properties
		y 92
		x 216
		view 441
	)
)

(instance Creak of Sound
	(properties
		number 50
	)
)

(instance Organ of Sound
	(properties
		number 63
	)
)

(instance mySound of Sound
	(properties
		number 43
	)
)

(instance PathIn of Path
	(properties)

	(method (at param1)
		(return [local4 param1])
	)
)

(instance PathOut of Path
	(properties)

	(method (at param1)
		(return [local11 param1])
	)
)

(instance StainedGlass of RFeature
	(properties
		nsTop 39
		nsLeft 48
		nsBottom 76
		nsRight 89
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/window'))
			(event claimed: 1)
			(Print 58 29) ; "You see a gorgeous, stained glass window."
		)
	)
)

(instance Altar of RFeature
	(properties
		nsTop 94
		nsLeft 65
		nsBottom 124
		nsRight 90
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/altar')
				(Print 58 30) ; "There is nothing inside the pulpit."
			)
			((or (MousedOn self event 3) (Said 'look/altar'))
				(event claimed: 1)
				(Print 58 31) ; "You see nothing special about the pulpit."
			)
		)
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 21
		nsLeft 161
		nsBottom 64
		nsRight 189
	)

	(method (handleEvent event)
		(cond
			((Said 'break/window')
				(Print 58 32) ; "There is no reason to do that."
			)
			((Said 'open/window')
				(Print 58 33) ; "The windows do not open."
			)
			((Said 'look<(out,through)/window')
				(Print 58 34) ; "You see nothing but darkness outside."
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(Print 58 35) ; "You notice other windows around the chapel."
			)
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 24
		nsLeft 219
		nsBottom 65
		nsRight 245
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 58 35) ; "You notice other windows around the chapel."
		)
	)
)

(instance Pew1 of RFeature
	(properties
		nsTop 78
		nsLeft 138
		nsBottom 108
		nsRight 214
	)

	(method (handleEvent event)
		(cond
			((Said 'sit[/down,bench]')
				(Print 58 36) ; "You don't feel like sitting around."
			)
			((Said 'look<below/bench')
				(Print 58 37) ; "There is nothing but dust under the old pews."
			)
			((or (MousedOn self event 3) (Said 'look/bench'))
				(event claimed: 1)
				(Print 58 38) ; "You see four pews in this small church."
			)
		)
	)
)

(instance Pew2 of RFeature
	(properties
		nsTop 124
		nsLeft 115
		nsBottom 174
		nsRight 214
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 58 38) ; "You see four pews in this small church."
		)
	)
)

