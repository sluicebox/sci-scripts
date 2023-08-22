;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	Room95 0
)

(synonyms
	(gull gull bird)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 2]
	local8
	local9
	local10
	local11
	local12
)

(instance fisherTheme of Sound
	(properties
		number 14
		priority -1
	)
)

(instance fallSound of Sound
	(properties
		number 51
		priority 3
	)
)

(instance Room95 of Rm
	(properties
		picture 95
	)

	(method (init)
		(Load rsVIEW 2)
		(Load rsVIEW 8)
		(Load rsVIEW 19)
		(if (gEgo has: 17) ; Fishing_Pole
			(Load rsVIEW 12)
			(Load rsVIEW 13)
			(Load rsVIEW 14)
		)
		(Load rsVIEW 17)
		(Load rsVIEW 234)
		(Load rsVIEW 230)
		(Load rsVIEW 327)
		(super init:)
		(if gNight
			(gCurRoom overlay: 195)
		)
		(self setRegions: 504) ; Gull_Region
		(= local1 0)
		(= south (= north 31))
		(= east 7)
		(= west 31)
		(= horizon 72)
		(gEgo edgeHit: EDGE_NONE)
		(= local0 0)
		(= global189 1)
		(= local8 (Prop new:))
		(local8
			view: 650
			loop: 1
			cel: 1
			posn: 155 57
			setPri: 0
			ignoreActors:
			setCycle: Fwd
			isExtra: 1
			init:
		)
		(if global223
			(= local9 (Prop new:))
			(= local10 (Prop new:))
			(local9
				view: 667
				loop: 3
				cel: 2
				posn: 216 178
				setPri: 0
				setCycle: Fwd
				ignoreActors:
				cycleSpeed: 2
				init:
			)
			(local10
				view: 667
				loop: 6
				cel: 3
				posn: 209 169
				setPri: 0
				setCycle: Fwd
				ignoreActors:
				cycleSpeed: 2
				init:
			)
		)
		(if (== global116 0)
			(= global116 1)
		)
		(switch gPrevRoomNum
			(0
				(gEgo loop: 1 setPri: 13)
				(= global105 0)
				(gEgo view: 2 posn: 317 144)
				(= global107 9)
			)
			(7
				(if (== global107 9)
					(gEgo x: 318 y: 144)
					(gEgo illegalBits: -16384)
					(gEgo setPri: 13)
				else
					(gEgo view: 8 setCycle: Fwd)
					(gEgo x: 318)
				)
			)
			(31
				(cond
					((<= (gEgo y:) global108)
						(gEgo
							posn: (gEgo x:) (+ horizon (gEgo yStep:) 1)
						)
					)
					((>= (gEgo y:) 189)
						(gEgo y: 188)
					)
					((>= (gEgo x:) 319)
						(gEgo x: 1)
					)
				)
				(if (<= (gEgo y:) horizon)
					(gEgo y: (+ horizon 2))
				)
				(gEgo view: 8 setCycle: Fwd)
			)
		)
		(if (not gNight)
			(= local5 (Act new:))
			(local5
				posn: 278 124
				view: 327
				loop: 0
				cel: 0
				xStep: 8
				yStep: 6
				illegalBits: 0
				ignoreActors:
				ignoreHorizon:
				setPri: 13
				setAvoider: (Avoid new:)
				init:
			)
			(local5 setScript: gullActions)
		)
		(if (== global116 1)
			(= local4 (Act new:))
			(fisherTheme play:)
			(local4
				view: 233
				posn: 177 145
				setPri: 13
				loop: 0
				setCycle: Fwd
				xStep: 3
				yStep: 2
				setScript: manActions
				init:
			)
			(= local3 1)
		)
		(gEgo xStep: 3 yStep: 2 init:)
		(if (and (== global107 9) (== local3 1))
			(gEgo observeControl: 32)
		)
	)

	(method (newRoom newRoomNumber)
		(= global189 0)
		(gEgo baseSetter: 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(or
					(and
						(gCast contains: local4)
						(local4 inRect: 249 138 305 148)
					)
					(and (== global107 9) (gEgo inRect: 249 138 305 148))
				)
				(== (gullActions state:) 0)
			)
			(gullActions changeState: 1)
		)
		(= local2 (gEgo onControl: 0))
		(if (and (== global107 9) (!= global105 15))
			(cond
				((& local2 $0010)
					(gEgo setScript: fallNorth)
				)
				((& local2 $0004)
					(gEgo setScript: fallSouth)
				)
				((& local2 $0008)
					(gEgo setScript: fallWest)
				)
			)
		)
		(if (or (== local3 0) (!= global107 9))
			(gEgo ignoreControl: 32)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'give>')
					(cond
						((Said '/*/gull')
							(Print 95 0) ; "The seagull has no interest in it"
						)
						((Said '/*[/fisherman,man,man,man,man]>')
							(if (= temp0 (gInventory saidMe:))
								(if (gEgo has: (gInventory indexOf: temp0))
									(Print 95 1) ; "The fisherman ignores you."
								else
									(Print 95 2) ; "You don't have that."
								)
							else
								(Print 95 3) ; "You can't give that."
								(event claimed: 1)
							)
						)
					)
				)
				((Said 'look>')
					(cond
						((Said '/fish')
							(if (gEgo has: 24) ; Dead_Fish
								((Inv at: 24) showSelf:) ; Dead_Fish
							else
								(Print 95 4) ; "You don't see any fish right now."
							)
						)
						((Said '/dock')
							(Print 95 5) ; "The pier is old and weather-beaten."
						)
						((Said '<under/dock')
							(Print 95 6) ; "There is only ocean under the old pier."
						)
						((Said '<under/water,ocean')
							(if (== (gEgo view:) 2)
								(Print 95 7) ; "Enter the water first."
							else
								(Print 95 8) ; "You look under the water, and see...more water!"
							)
						)
						((Said '/barrel')
							(Print 95 9) ; "There is nothing of interest in the wooden barrel."
						)
						((Said '/ocean,water')
							(Print 95 10) ; "The wide, blue ocean disappears into the horizon to the west."
						)
						((Said '/gull,gull,gull')
							(if (gCast contains: local5)
								(Print 95 11) ; "It's just an ordinary seagull."
							else
								(event claimed: 0)
							)
						)
						((Said '/hemp')
							(Print 95 12) ; "You see an old rotted rope attached to the pier."
						)
						((Said '/fisherman,man,man,man,man')
							(if (== global116 1)
								(Print 95 13) ; "You see a grizzled, old fisherman on the pier. Apparently, he isn't having any luck today."
							else
								(Print 95 14) ; "You don't see him here."
							)
						)
						((Said '[<around][/room]')
							(if (== (gEgo view:) 2)
								(Print 95 15) ; "You are standing at the end of an old weathered pier. From here, to the west, you can see nothing but ocean."
							else
								(Print 95 16) ; "You are swimming near the end of an old weathered pier. From here, to the west, you can see nothing but ocean."
							)
						)
					)
				)
			)
			(cond
				((Said 'open/barrel')
					(Print 95 9) ; "There is nothing of interest in the wooden barrel."
				)
				((or (Said 'drink') (Said 'get/drink'))
					(if (== (gEgo view:) 2)
						(Print 95 17) ; "You can't when you're on the pier."
					else
						(Print 95 18) ; "You taste the ocean water. YUCK!! This water's too salty!"
					)
				)
				((Said 'hop,(dive<in)')
					(if (== (gEgo view:) 2)
						(Print 95 19) ; "Just jump on in!"
					else
						(Print 95 20) ; "You are already in the water."
					)
				)
				((Said 'dive,(bathe<under)[/ocean,water]')
					(Print 95 21) ; "The water is much too deep here."
				)
				((Said 'bathe')
					(if (== (gEgo view:) 2)
						(Print 95 19) ; "Just jump on in!"
					else
						(Print 95 22) ; "You're already swimming."
					)
				)
				((Said 'get/hemp')
					(Print 95 23) ; "You wouldn't want it. It's of no use to you."
				)
				(
					(or
						(Said 'fish[<enter][/!*]')
						(Said 'capture,get/fish')
						(Said 'cast/pole')
					)
					(if (== global107 9)
						(gCurRoom setScript: fishing)
						(fishing changeState: 1)
					else
						(Print 95 24) ; "Not while you're swimming."
					)
				)
				((Said '/pole>')
					(cond
						((gEgo has: 17) ; Fishing_Pole
							(cond
								((Said 'bait')
									(event claimed: 0)
								)
								((Said 'get')
									(AlreadyTook) ; "You already took it."
								)
								((Said 'use')
									(Print 95 25) ; "What do you want to do with it?"
								)
							)
						)
						((not (gCast contains: local4))
							(event claimed: 1)
							(Print 95 26) ; "You don't see one here."
						)
						((Said 'get')
							(Print 95 27) ; "It's his, Rosella!"
						)
						((Said 'rob')
							(Print 95 28) ; "You're not a thief, Rosella!"
						)
					)
				)
				((Said '/gull>')
					(cond
						((not (gCast contains: local5)) 0)
						((Said 'feed')
							(Print 95 29) ; "The seagull is not interested."
						)
						((Said 'kiss')
							(Print 95 30) ; "You can't kiss a seagull."
						)
						((Said 'talk')
							(Print 95 31) ; "Seagulls don't talk."
						)
						((Said 'capture,get')
							(Print 95 32) ; "You can't catch the seagull."
						)
					)
				)
				((Said '[/fisherman,man,man,man,man]>')
					(cond
						((Said 'get/*')
							(if (== global116 1)
								(Print 95 33) ; "You couldn't get the fisherman."
							else
								(Print 95 34) ; "You don't see him."
							)
						)
						((Said 'help')
							(Print 95 35) ; "How can you do that, Rosella?"
						)
						((Said 'kiss')
							(if (== global116 1)
								(Print 95 36) ; "You think for a moment that it might help, but then change your mind."
							else
								(Print 95 34) ; "You don't see him."
							)
						)
						((Said 'talk')
							(if (gCast contains: local4)
								(Print 95 37) ; "You say a few words to the old fisherman. However, he must have other things on his mind as he seems to ignore you."
							else
								(Print 95 38) ; "There is no one nearby."
							)
						)
					)
				)
			)
		)
	)
)

(instance fallSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global189 1)
				(= global107 0)
				(fallSound play:)
				(gEgo
					illegalBits: 0
					yStep: 10
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 34) self
					setPri: 15
					view: 17
					cel: 255
					setCycle: End
				)
			)
			(1
				(gEgo yStep: 2 setPri: -1)
				(gEgo
					view: 19
					loop: (& (gEgo loop:) $0001)
					illegalBits: -32768
					cel: 255
					setCycle: End self
				)
			)
			(2
				(gEgo view: 8 setCycle: Fwd illegalBits: -32768 setPri: -1)
				(HandsOn)
				(= global107 0)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance fallNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global107 0)
				(fallSound play:)
				(gEgo
					illegalBits: 0
					setPri: 11
					posn: (gEgo x:) (- (gEgo y:) 5)
					yStep: 10
					view: 17
					cel: 255
					setCycle: End
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 20) self
				)
			)
			(1
				(gEgo
					view: 8
					setCycle: Fwd
					setStep: 3 2
					setPri: -1
					illegalBits: -32768
				)
				(HandsOn)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance fallWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global107 0)
				(fallSound play:)
				(gEgo illegalBits: 0)
				(gEgo view: 17 setCycle: Fwd setStep: 10 8 cel: 0)
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 30)
						(+ (gEgo y:) 20)
						self
				)
			)
			(1
				(gEgo
					view: 19
					loop: (& (gEgo loop:) $0001)
					illegalBits: -32768
					cel: 255
					setPri: -1
					setCycle: End self
				)
			)
			(2
				(gEgo view: 8 xStep: 3 yStep: 2 setCycle: Fwd)
				(HandsOn)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance manActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 4) setReal: self 15) ; timer1
			)
			(1
				(local4 view: 234 loop: 0 cel: 255 setCycle: End self)
			)
			(2
				(local4 loop: 1 cel: 255 setCycle: End self)
			)
			(3
				(local4 view: 230 setCycle: Walk setMotion: MoveTo 319 146 self)
				(= local3 0)
			)
			(4
				(= global197 global159)
				(= global198 global158)
				(= global199 global160)
				(= global116 2)
				(local4 dispose:)
				(= local4 0)
			)
		)
	)
)

(instance gullActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(local5 view: 327 cel: 255 loop: 0 setCycle: End self)
			)
			(2
				(local5 loop: 1 cel: 0 setCycle: Fwd)
				(local5 setMotion: MoveTo -10 25 self)
			)
			(3
				(local5 dispose:)
			)
		)
	)
)

(instance fishing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo baseSetter: (ScriptID 0 1)) ; smallBase
				(= global105 15)
				(cond
					((and (gEgo has: 17) ((Inv at: 19) ownedBy: 666)) ; Fishing_Pole, Worm
						(self changeState: 9)
					)
					((gEgo has: 17) ; Fishing_Pole
						(self changeState: 19)
					)
					(else
						(Print 95 39) ; "With what?"
						(= global105 0)
						(fishing changeState: 0)
					)
				)
			)
			(9
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 144 self)
			)
			(10
				(gEgo setMotion: MoveTo 189 145 self)
			)
			(11
				(Print 95 40 #at -1 15) ; "Eagerly, from the end of the pier, you fling the baited line of the fishing pole into the ocean."
				(gEgo
					view: 13
					loop: 2
					cel: 3
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(12
				(gEgo view: 12 loop: 0 cycleSpeed: 0 setCycle: Fwd)
				((ScriptID 0 4) setReal: self 7) ; timer1
			)
			(13
				(if (< (Random 1 100) 50)
					(gEgo loop: 1)
					(Print 95 41 #at -1 15) ; "Almost immediately, you feel a sharp tug on the line! Something pulls and fights your line as you slowly reel it in. There it is! You have caught yourself...a fine fat fish!"
					(self changeState: 14)
					((Inv at: 17) loop: 0) ; Fishing_Pole
				else
					(self changeState: 50)
				)
			)
			(14
				(gEgo view: 14 loop: 1 cel: 255 cycleSpeed: 1 setCycle: End)
				(= seconds 4)
			)
			(15
				(= global182 1)
				(gEgo
					view: 2
					setLoop: -1
					loop: 1
					cycleSpeed: 0
					setCycle: Walk
					baseSetter: 0
				)
				(= global105 0)
				(HandsOn)
				((Inv at: 24) moveTo: gEgo) ; Dead_Fish
				(gGame changeScore: 3)
				((Inv at: 19) moveTo: 777) ; Worm
				(gCurRoom setScript: 0)
			)
			(19
				(HandsOff)
				(if (and (<= (gEgo y:) 141) (>= (gEgo x:) 289))
					(gEgo setMotion: MoveTo (gEgo x:) 143 self)
				else
					(self changeState: 20)
				)
			)
			(20
				(HandsOff)
				(gEgo setMotion: MoveTo 189 145 self)
			)
			(21
				(Print 95 42 #at -1 15) ; "Eagerly, from the end of the pier, you fling the line of the fishing pole into the ocean."
				(gEgo
					view: 13
					loop: 1
					cel: 3
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(22
				(gEgo view: 12 loop: 0 cycleSpeed: 0 setCycle: Fwd)
				((ScriptID 0 4) setReal: self 7) ; timer1
			)
			(23
				(if (and (< (Random 1 100) 50) (== local12 0))
					(gEgo loop: 1)
					(self changeState: 24)
				else
					(Print 95 43 #at -1 15) ; "But wait! You haven't baited your hook! Feeling rather sheepish, you reel in your empty fishing line."
					(self changeState: 30)
				)
			)
			(24
				(gEgo view: 14 loop: 0 cel: 255 cycleSpeed: 1 setCycle: End)
				(= seconds 4)
			)
			(25
				(Print 95 44 #at -1 15) ; "Almost immediately, you feel a sharp tug on the line! Something pulls and fights your line as you slowly reel it in. There it is! You have caught yourself...an old waterlogged boot. But, since you have no need of a boot, you toss it back into the water."
				(= local12 1)
				(gEgo
					view: 2
					setLoop: -1
					loop: 1
					cycleSpeed: 0
					setCycle: Walk
					baseSetter: 0
				)
				(= global105 0)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
			(30
				(gEgo view: 13 cel: 255 loop: 1 cycleSpeed: 2 setCycle: End)
				(= seconds 3)
			)
			(31
				(gEgo
					view: 2
					setLoop: -1
					cycleSpeed: 0
					loop: 1
					setCycle: Walk
					baseSetter: 0
				)
				(= global105 0)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
			(50
				(gEgo view: 13 cel: 255 loop: 2 cycleSpeed: 2 setCycle: End)
				((ScriptID 0 4) setReal: self 4) ; timer1
			)
			(51
				(Print 95 45 #at -1 15) ; "The fish don't seem to be biting."
				(gEgo
					view: 2
					loop: 1
					cycleSpeed: 0
					setCycle: Walk
					baseSetter: 0
				)
				(= global105 0)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

