;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use Rev)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm52 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(cond
		((== (gEgo view:) 14)
			(Print 52 27) ; "Too late! Your vision grows blurred as you go down for the third time."
		)
		((and (< 159 (gEgo x:) 252) (> (gEgo y:) 125))
			(Print 52 41) ; "This looks like a typical weed."
		)
		(else
			(Print 52 26) ; "You are too far away to see clearly."
		)
	)
)

(instance rm52 of Rm
	(properties
		picture 52
		north 49
		west 51
	)

	(method (init)
		(LoadMany rsVIEW 1 6 9 13 14 252 68)
		(LoadMany rsSOUND 72 96 14 64)
		(self
			style:
				(switch gPrevRoomNum
					(north 8)
					(east 2)
				)
		)
		(weed1 setCycle: Fwd setPri: 0 init: ignoreActors:)
		(weed2 setCycle: Rev setPri: 0 init: ignoreActors:)
		(weed3 setCycle: Fwd setPri: 0 init: ignoreActors:)
		(weed4 setCycle: Rev init: ignoreActors:)
		(if (not (>= global101 1))
			(weed1 stopUpd:)
			(weed2 stopUpd:)
			(weed3 stopUpd:)
			(weed4 stopUpd:)
		)
		(super init:)
		(gAddToPics add: trunk eachElementDo: #init doit:)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 14 58 illegalBits: -32512 loop: 0)
				(proc0_1)
			)
			(else
				(gEgo
					ignoreActors:
					illegalBits: -32768
					posn: 204 20
					setMotion: MoveTo 204 130
					setCycle: Fwd
					setPri: -1
					view: 6
				)
				(= global130 4)
				(= local0 300)
				((ScriptID 0 23) number: 72 loop: -1 playBed:) ; backSound
			)
		)
		(gEgo init:)
	)

	(method (doit &tmp temp0)
		(if (and (== global130 4) global136 (not (-- global136)))
			(gCurRoom setScript: drowning)
		)
		(if (== (gEgo view:) 6)
			(if
				(or
					(< (gEgo y:) 148)
					(> (gEgo y:) 158)
					(< (gEgo x:) 140)
				)
				(gEgo illegalBits: -32768)
			else
				(gEgo illegalBits: 0)
			)
		)
		(cond
			(script
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(if (!= temp0 west)
					((ScriptID 0 23) fade:) ; backSound
				)
				(self newRoom: temp0)
			)
			((& (gEgo onControl: 1) $4000)
				(gCurRoom setScript: upToSurface)
			)
			(
				(and
					(or (== (gEgo view:) 0) (== (gEgo view:) 36))
					(& (gEgo onControl: 1) $0400)
					(not global103)
				)
				(gCurRoom setScript: fallInWater)
			)
			(local0
				(-- local0)
				(if (== (gEgo view:) 6)
					(switch (gEgo loop:)
						(3
							(gEgo setStep: 1 3)
						)
						(2
							(gEgo setStep: 1 1)
						)
						(0
							(gEgo setStep: 3 1)
						)
						(1
							(gEgo setStep: 3 1)
						)
					)
				)
			)
			((== (gEgo view:) 6)
				(gCurRoom setScript: drownEgo)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'smell,smell/')
				(if (== (gEgo view:) 6)
					(Print 52 0) ; "As your nose fills with the aroma of fresh well water, your lungs give out. Don't smell the water!"
					(gCurRoom setScript: drownEgo)
				else
					(event claimed: 0)
				)
			)
			((Said 'dive')
				(switch (gEgo view:)
					(14
						(Print 52 1) ; "It's too late to dive. At this point, all you can do is drown."
					)
					(6
						(Print 52 2) ; "You are already doing that!"
					)
					(13
						(gCurRoom setScript: goDiving)
					)
					(else
						(Print 52 3) ; "You need to be swimming first."
					)
				)
			)
			((Said 'swim<stop')
				(switch (gEgo view:)
					(14
						(Print 52 4) ; "Too late! You have already stopped swimming and started drowning."
					)
					(13
						(Print 52 5) ; "There is no reason to stop swimming. You may drown."
					)
					(else
						(Print 52 6) ; "You cannot stop something you haven't started."
					)
				)
			)
			((Said 'swim')
				(switch (gEgo view:)
					(13
						(Print 52 7) ; "You already are swimming."
					)
					(14
						(= global130 4)
						((ScriptID 0 21) number: 51 loop: -1 init: play:) ; gameSound
						(gEgo
							show:
							view: 13
							illegalBits: -24576
							setStep: 1 1
							setCycle: Fwd
							setLoop: -1
							setCel: -1
							setPri: -1
							cycleSpeed: 0
						)
						(= global136 3000)
						(gCurRoom setScript: 0)
						(HandsOn)
					)
					(6
						(Print 52 2) ; "You are already doing that!"
					)
					(else
						(gCurRoom setScript: goSwimming)
					)
				)
			)
			((Said 'climb,climb[<in]/water')
				(if (not global130)
					(Print 52 8) ; "Just walk over to the water."
				else
					(Print 52 9) ; "You're already in the water."
				)
			)
			((or (Said 'climb,climb,get,get<out') (Said 'exit/water'))
				(switch (gEgo view:)
					(14
						(Print 52 10) ; "You've swum too long already! Your endurance has run out."
					)
					(6
						(Print 52 11) ; "You can't do that from under water!"
					)
					(13
						(gCurRoom setScript: getOutaWater)
					)
					(else
						(Print 52 3) ; "You need to be swimming first."
					)
				)
			)
			((Said 'climb,climb[/!*]')
				(Print 52 12) ; "There's no reason to climb anything here."
			)
			((Said 'get,get/chest')
				(Print 52 13) ; "This isn't the chest you're looking for."
			)
			((Said 'enter,(get,get,jump<in)/water')
				(Print 52 14) ; "All you have to do is walk right into the water."
			)
			((Said 'enter,(get,get,jump<in)')
				(Print 52 15) ; "What would you like to get into?"
			)
			((or (Said 'get,get/water') (Said 'fill/bucket'))
				(cond
					((== (gEgo view:) 14)
						(Print 52 16) ; "You're too busy drowning at the moment."
					)
					(
						(and
							(not (& (gEgo onControl: 1) $2000))
							(not (OneOf (gEgo view:) 6 13))
						)
						(Print 52 17) ; "You are not close enough to the water."
					)
					((gEgo has: 8) ; Empty_Water_Bucket
						(if (IsFlag 9)
							(Print 52 18) ; "The bucket is already full of water."
						else
							(if (OneOf (gEgo view:) 6 13)
								(Print 52 19) ; "With difficulty, you fill the bucket while swimming."
							else
								(self setScript: fillBucket)
							)
							(UpdateWaterBucket 1)
						)
					)
					(else
						(Print 52 20) ; "You do not have a bucket to put the water in."
					)
				)
			)
			((or (Said 'get,get/drink') (Said 'drink[/water]'))
				(cond
					((== (gEgo view:) 14)
						(Print 52 21) ; "You're too busy drowning right now."
					)
					(
						(and
							(not (& (gEgo onControl: 1) $2000))
							(not (OneOf (gEgo view:) 6 13))
						)
						(if (and (gEgo has: 8) (IsFlag 9)) ; Empty_Water_Bucket
							(Print 52 22) ; "You drink all the water in the bucket. You must have been thirsty!"
							(UpdateWaterBucket 0)
						else
							(Print 52 17) ; "You are not close enough to the water."
						)
					)
					(else
						(Print 52 23) ; "You take a deep drink of the cold well water."
					)
				)
			)
			((Said '/hinge')
				(Print 52 24) ; "The hinges are rusted, but still very strong."
			)
			((or (Said 'look,look/hole') (proc0_14 event 47 48 99 62))
				(if (< (gEgo x:) 128)
					(Print 52 25) ; "This dark pool of water leads to the bottom of the ancient well near King Edward's castle."
				else
					(Print 52 26) ; "You are too far away to see clearly."
				)
			)
			((Said 'look,look>')
				(cond
					((Said '<up')
						(cond
							((== (gEgo view:) 14)
								(Print 52 27) ; "Too late! Your vision grows blurred as you go down for the third time."
							)
							(
								(and
									(== (gEgo view:) 6)
									(gEgo inRect: 19 105 136 187)
								)
								(Print 52 28) ; "You can see the surface of the water just above you."
							)
							((== (gEgo view:) 6)
								(Print 52 29) ; "You can just see the opening of the well far above you."
							)
							(else
								(Print 52 30) ; "You see the low ceiling of the cave just above you."
							)
						)
					)
					((Said '[<at,around][/room,well,cave]')
						(switch (gEgo view:)
							(6
								(if (< (gEgo y:) 118)
									(Print 52 31) ; "You can see the bottom of the well below you."
								else
									(Print 52 32) ; "You are at the bottom of the well. Through the plants you spy what seems to be a hole in the side of the well."
								)
							)
							(else
								(Print 52 33) ; "The cave is dark and very damp."
							)
						)
					)
					((Said '/water')
						(Print 52 34) ; "This looks like typical well water."
					)
				)
			)
		)
	)
)

(instance weed1 of Prop
	(properties
		x 220
		y 133
		description {weed}
		view 252
		cel 4
		cycleSpeed 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(localproc_0)
			)
		)
	)
)

(instance weed2 of Prop
	(properties
		x 149
		y 157
		description {weed}
		view 252
		loop 1
		cel 1
		cycleSpeed 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(localproc_0)
			)
		)
	)
)

(instance weed3 of Prop
	(properties
		x 264
		y 140
		description {weed}
		view 252
		loop 1
		cel 2
		cycleSpeed 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(localproc_0)
			)
		)
	)
)

(instance weed4 of Prop
	(properties
		x 187
		y 163
		description {weed}
		view 252
		cel 3
		cycleSpeed 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(localproc_0)
			)
		)
	)
)

(instance trunk of PicView
	(properties
		x 194
		y 152
		noun 'chest'
		description {chest}
		view 252
		loop 2
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/chest')
				(self doVerb: 1 event)
			)
			((or (Said 'look,look<down') (Said 'look,look/floor'))
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(Print 52 35) ; "The chest is buried deep in the sand and is too heavy to carry."
			)
			(2
				(Print 52 36) ; "The lid's hinges are rusted shut."
			)
			(else
				(cond
					((== (gEgo view:) 14)
						(Print 52 27) ; "Too late! Your vision grows blurred as you go down for the third time."
					)
					((gEgo has: 1) ; Chest
						((gInventory at: 1) showSelf: gEgo) ; Chest
						(Print 52 37) ; "The half-buried chest looks as if it has been here for a very long time."
					)
					(
						(or
							(and (< 159 (gEgo x:) 252) (> (gEgo y:) 125))
							(< argc 1)
						)
						(Print 52 38) ; "It looks like this chest has been buried here for a very long time."
					)
					(else
						(Print 52 26) ; "You are too far away to see clearly."
					)
				)
			)
		)
	)
)

(instance upToSurface of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo hide:)
				(= cycles 9)
			)
			(1
				(= global130 4)
				(= global136 3000)
				(gEgo
					show:
					posn: 73 57
					illegalBits: -24576
					setStep: 1 1
					view: 13
					setCycle: Fwd
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getOutaWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) loop: 1 stop:) ; gameSound
				((ScriptID 0 23) loop: 1 fade:) ; backSound
				(gEgo illegalBits: 0 setLoop: 1 setMotion: MoveTo 65 58 self)
			)
			(1
				(gEgo
					view: 9
					cel: 0
					setLoop: 0
					cycleSpeed: 1
					posn: 43 55
					setCycle: End self
				)
			)
			(2
				(= global130 0)
				(proc0_1)
				(gEgo
					loop: 1
					illegalBits: -32512
					setMotion: MoveTo 32 54 self
				)
			)
			(3
				(if (and (not (IsFlag 83)) (not (IsFlag 82)))
					((ScriptID 0 23) number: 64 loop: -1 playBed:) ; backSound
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance drownEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cycleSpeed: 1 setMotion: 0)
				(= cycles 14)
			)
			(1
				(HandsOff)
				(gEgo
					setLoop: (if (gEgo loop:) 5 else 4)
					setCycle: 0
					setCel: 0
				)
				(= cycles 4)
			)
			(2
				(gEgo
					setStep: 1 1
					moveSpeed: 1
					setMotion: MoveTo (gEgo x:) 200
				)
				(= seconds 9)
			)
			(3
				(EgoDead {Well, well, well!__Water you going to do now?})
			)
		)
	)
)

(instance goSwimming of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 43 55 self)
			)
			(1
				(if (IsFlag 1)
					(Print 52 39) ; "As you get into the water, the magic ring slips from your finger and vanishes."
					(ClearFlag 1)
					(ClearFlag 17)
					(proc0_8 5)
					(gGame changeScore: -3)
					(self cue:)
				else
					(self cue:)
				)
			)
			(2
				(= global136 3000)
				(= global130 4)
				(gEgo view: 9 setLoop: 0 cel: 6 setCycle: Beg self)
			)
			(3
				(gEgo
					view: 13
					setLoop: -1
					setCycle: Fwd
					illegalBits: -24576
					posn: 72 59
					setMotion: MoveTo 73 57 self
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goDiving of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) loop: 1 fade:) ; gameSound
				(gEgo view: 14 cel: 8 setLoop: 0 setCycle: End self)
			)
			(1
				(= cycles 6)
			)
			(2
				((ScriptID 0 23) number: 72 loop: -1 playBed:) ; backSound
				(gEgo
					show:
					setLoop: -1
					loop: 2
					ignoreActors: 1
					posn: 70 130
					setMotion: MoveTo 70 184
					looper: 0
					setCycle: Fwd
					view: 6
				)
				(= global130 4)
				(= local0 300)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fallInWater of Script
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'swim')
				(HandsOn)
				((ScriptID 0 23) stop:) ; backSound
				(gEgo
					illegalBits: -24576
					view: 13
					setLoop: -1
					cycleSpeed: 0
					setCycle: Fwd
				)
				(= seconds 0)
				(self dispose:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 23) loop: -1 fade:) ; backSound
				(gEgo
					view: 14
					setLoop: 1
					cel: 0
					setCycle: 0
					cycleSpeed: 0
					setMotion: JumpTo 77 55 self
				)
				(= global130 4)
			)
			(1
				((ScriptID 0 21) number: 14 loop: 1 init: play:) ; gameSound
				(gEgo cel: 1 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(= global130 4)
				((ScriptID 0 21) number: 51 loop: -1 play:) ; gameSound
				(gEgo
					show:
					view: 13
					illegalBits: -24576
					setStep: 1 1
					setCycle: Fwd
					setLoop: -1
					setCel: -1
					setPri: -1
					cycleSpeed: 0
				)
				(= global136 3000)
				(gCurRoom setScript: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance drowning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(gEgo
					setMotion: 0
					setLoop: 0
					view: 14
					cel: 5
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(gEgo cel: 5 setCycle: End self)
			)
			(2
				(gEgo cel: 5 setCycle: End self)
			)
			(3
				(gEgo hide:)
				(= cycles 40)
			)
			(4
				(gEgo
					view: 6
					loop: (Random 4 5)
					posn: (gEgo x:) 120
					show:
					setStep: 1 1
					illegalBits: 0
					moveSpeed: 1
					setMotion: MoveTo (gEgo x:) 155 self
				)
			)
			(5
				(if (not global136)
					(EgoDead
						{After swimming for a long time, your strength ebbs and your arms and legs grow weary.__As your life swims before your eyes, you decide to...}
					)
				else
					(EgoDead
						{You splash around for awhile, but unfortunately that won't keep your head above water.__As you go down for the third time, a sense of peace washes over you...}
					)
				)
			)
		)
	)
)

(instance fillBucket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 41 54 self)
			)
			(1
				(gEgo view: 68 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(Print 52 40) ; "You kneel down and fill the bucket with the cool water."
				(self cue:)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 2 loop: 0)
				(proc0_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

