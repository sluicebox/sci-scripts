;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	sewer 0
)

(local
	[local0 100]
	local100
	local101
)

(procedure (localproc_0 param1)
	(cond
		((== (param1 cel:) 3)
			(return 0)
		)
		((and (> (- (param1 x:) (gEgo x:)) 20) (== (gEgo loop:) 0))
			(return 1)
		)
		((and (< (- (param1 x:) (gEgo x:)) -20) (== (gEgo loop:) 1))
			(return 1)
		)
		(else
			(return 0)
		)
	)
)

(instance lightObj of Prop
	(properties
		view 99
		loop 6
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (Said '/light>')
					(cond
						((Said 'get')
							(Print 205 0) ; "The lights are permanent fixtures."
						)
						((Said 'turn<(on,off)')
							(Print 205 1) ; "It does not have an on/off switch"
						)
					)
				)
			)
		)
	)
)

(instance ratScript of Script
	(properties)

	(method (changeState newState param2)
		(switch (= state newState)
			(1
				(switch (param2 name:)
					(1
						(param2 setLoop: 7 setMotion: MoveTo 102 91 param2)
					)
					(2
						(param2 setLoop: 2 setMotion: MoveTo 249 65 param2)
					)
					(3
						(param2 setLoop: 7 setMotion: MoveTo 72 95 param2)
					)
					(4
						(param2 setLoop: 3 setMotion: MoveTo 70 66 param2)
					)
					(5
						(param2 setLoop: 6 setMotion: MoveTo 212 86 param2)
					)
					(6
						(param2 setLoop: 6 setMotion: MoveTo 232 93 param2)
					)
					(7
						(param2 setLoop: 3 setMotion: MoveTo 287 57 param2)
					)
				)
			)
			(2
				(switch (param2 name:)
					(1
						(param2 setLoop: 5 setMotion: MoveTo -100 172 param2)
					)
					(2
						(param2 setLoop: 3 setMotion: MoveTo 400 65 param2)
					)
					(3
						(param2 setLoop: 5 setMotion: MoveTo -100 167 param2)
					)
					(4
						(param2 setLoop: 2 setMotion: MoveTo -100 66 param2)
					)
					(5
						(param2 setLoop: 4 setMotion: MoveTo 400 163 param2)
					)
					(6
						(param2 setLoop: 4 setMotion: MoveTo 400 149 param2)
					)
					(7
						(param2 setLoop: 2 setMotion: MoveTo -100 57 param2)
					)
				)
			)
		)
	)
)

(instance ratObj of Act
	(properties
		view 260
		illegalBits 0
		xStep 2
		moveSpeed 1
	)

	(method (cue)
		(if (== (ratScript state:) 1)
			(ratScript changeState: 2 self)
		else
			(ratScript changeState: 1 self)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (Said '/mice>')
					(cond
						((Said 'look')
							(Print 205 2) ; "Your flesh crawls as you gaze at the subterranean rodent."
						)
						((Said 'get,apprehend')
							(Print 205 3) ; "You have more important objectives."
						)
						((Said 'kill')
							(Print 205 4) ; "The rat is too quick."
						)
						((Said 'eat')
							(Print 205 5) ; "You're not hungry right now."
						)
						(else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

(instance sewer of Rgn
	(properties)

	(method (init)
		(super init:)
		(= gRatObj ratObj)
		(= gLightObj lightObj)
		(if
			(or
				(== gCurRoomNum 123)
				(== gCurRoomNum 130)
				(== gCurRoomNum 120)
				(== gCurRoomNum 124)
				(== gCurRoomNum 129)
				(== gCurRoomNum 125)
				(== gCurRoomNum 132)
				(== gCurRoomNum 127)
				(== gCurRoomNum 122)
				(== gCurRoomNum 128)
			)
			(= global115 (gLightObj new:))
		)
		(if (== global156 0)
			(= global156 -1)
			(= global239 -1)
		)
		(Load rsVIEW 0)
		(Load rsVIEW 4)
		(Load rsVIEW 6)
		(Load rsVIEW 99)
		(Load rsVIEW 260)
		(Load rsSOUND 41)
		(if (gEgo has: 32) ; gas_mask
			(Load rsVIEW 296)
			(Load rsVIEW 305)
			(Load rsVIEW 306)
		)
		(= global212 0)
		(= global211 0)
	)

	(method (handleEvent event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((Said 'look>')
				(cond
					((Said '[<at,around][/(!*,chamber)]')
						(Print
							(Format ; "You see walkways and grates that lead around the dark and smelly sewer. Pipes line the walls, and lights barely illuminate the darkness.%s"
								@local0
								205
								6
								(if
									(and
										(!= gCurRoomNum 122)
										(!= gCurRoomNum 123)
										(!= gCurRoomNum 125)
										(!= gCurRoomNum 127)
										(!= gCurRoomNum 129)
									)
									{ Rats scurry about the sewer pipes.}
								else
									{}
								)
							)
						)
						(if
							(or
								(== gCurRoomNum 121)
								(== gCurRoomNum 126)
								(== gCurRoomNum 130)
							)
							(Print 205 7) ; "You see a drain pipe on the wall."
						)
						(if
							(or
								(== gCurRoomNum 120)
								(== gCurRoomNum 124)
								(== gCurRoomNum 128)
							)
							(Print 205 8) ; "A brightly-colored ladder leads to the surface."
						)
					)
					((Said '/slime')
						(Print 205 9) ; "The slime slowly seeps through the sewer."
					)
					((Said '/bridge')
						(Print 205 10) ; "The metal grate spans the sickening sewer water."
					)
					((Said '/outlet<drain')
						(if (or (== gCurRoomNum 121) (== gCurRoomNum 126))
							(Print 205 11) ; "The drain pipe looks kind of lethal."
						else
							(Print 205 12) ; "What drain pipe?"
						)
					)
					((Said '/drain')
						(if (or (== gCurRoomNum 121) (== gCurRoomNum 126))
							(Print 205 13) ; "Sewer water rushes beneath the drain into the main sewer."
						else
							(Print 205 14) ; "What drain?"
						)
					)
					((Said '/faucet')
						(if
							(or
								(== gCurRoomNum 124)
								(== gCurRoomNum 126)
								(== gCurRoomNum 132)
								(== gCurRoomNum 121)
							)
							(Print 205 15) ; "The faucet can only be turned on with a special wrench."
						else
							(Print 205 16) ; "What faucet?"
						)
					)
					((Said '/wall')
						(Print 205 17) ; "The slime and dampness on the walls make you cringe."
					)
					((Said '/bug')
						(Print 205 18) ; "You don't see any bugs here."
					)
					((Said '/outlet')
						(Print 205 19) ; "On the pipe, you see a rat scurrying about its business."
					)
					((Said '[<at,down][/dirt,floor]')
						(Print 205 20) ; "The slimy brick walkway makes the footing difficult."
					)
					((Said '[<at,up][/ceiling]')
						(Print 205 21) ; "The ceiling of the sewer doesn't look any better than the ground - slime, slime, slime."
					)
					((Said '/sewer,water')
						(Print 205 22) ; "As you look into the murky fluid, you think to yourself... "Mercy sakes, how nasty!""
					)
					((Said '/light')
						(Print
							(Format ; "One light %s%s"
								@local0
								205
								23
								(if (== (gLightObj cel:) 3)
									{has been shot out.}
								else
									{is on.}
								)
								(cond
									((not (gCast contains: global115)) {})
									((== (global115 cel:) 3) {The other light has been shot out.})
									(else {The other light is on.})
								)
							)
						)
					)
				)
			)
			((Said 'listen')
				(Print 205 24) ; "A distant echo and the occasional sound of dripping water is all that you hear."
			)
			((Said 'smell[/*]')
				(Print 205 25) ; "The pungent odor stifles your nostrils."
			)
			((or (Said 'extender') (Said 'use/extender,talkie,walkie'))
				(if (gEgo has: 30) ; walkie_talkie
					(Print 205 26) ; "Your walkie talkie does not seem to be working in here."
				else
					(proc0_9) ; "You don't have it."
				)
			)
			((Said 'turn,use/faucet')
				(if
					(or
						(== gCurRoomNum 121)
						(== gCurRoomNum 124)
						(== gCurRoomNum 126)
						(== gCurRoomNum 132)
					)
					(Print 205 27) ; "You can't do anything with the faucet."
				else
					(Print 205 16) ; "What faucet?"
				)
			)
			((Said 'remove/mask')
				(cond
					((not (gEgo has: 32)) ; gas_mask
						(Print 205 28) ; "What mask?"
					)
					((not global140)
						(Print 205 29) ; "You don't have the gas mask on."
					)
					(else
						(= global140 0)
						(if (== (gEgo view:) 296)
							(gEgo view: 0)
						else
							(gEgo view: 6)
						)
					)
				)
			)
			((Said 'wear,drop/mask')
				(cond
					((not (gEgo has: 32)) ; gas_mask
						(Print 205 30) ; "You don't have a mask."
					)
					((== global156 -1)
						(Print 205 31) ; "You don't need to wear the mask now."
					)
					(global140
						(Print 205 32) ; "You already are."
					)
					(else
						(= global140 1)
						(if (== (gEgo view:) 0)
							(gEgo view: 296)
						else
							(gEgo view: 306)
						)
					)
				)
			)
		)
	)

	(method (doit)
		(if (!= global156 global239)
			(if (== global156 -1)
				(gContinuousMusic stop: number: 9 priority: 6 loop: -1 play:)
			)
			(= global239 global156)
		)
		(if global205
			(= global205 0)
			(cond
				((!= global156 -1)
					(pBoomScript changeState: 1)
				)
				((not (gCast contains: global115))
					(if (localproc_0 gLightObj)
						(gLightObj startUpd: setCycle: End)
					)
				)
				((and (localproc_0 gLightObj) (localproc_0 global115))
					(if
						(<=
							(gEgo distanceTo: gLightObj)
							(gEgo distanceTo: global115)
						)
						(gLightObj setCycle: End)
					else
						(global115 setCycle: End)
					)
				)
				((localproc_0 gLightObj)
					(gLightObj setCycle: End)
				)
				((localproc_0 global115)
					(global115 setCycle: End)
				)
			)
		)
		(if (and (> global156 0) (not global140) (not global139))
			(switch (-- global156)
				(0
					(asphyxiation changeState: 0)
				)
				(20
					(Print 205 33) ; "You feel weak and light-headed."
				)
				(40
					(Print 205 34) ; "Your breathing becomes labored, and you can't seem to get enough air."
				)
				(60
					(Print 205 35) ; "You feel a burning sensation in your eyes."
					(gContinuousMusic number: 32 loop: -1 priority: 6 play:)
				)
			)
		)
		(if (and (& (gEgo onControl: 1) $003c) (not global139))
			(HandsOff)
			(= global139 1)
			(gEgo
				view: 99
				setLoop: 4
				setStep: 5 2
				setMotion: 0
				illegalBits: 0
				setScript: fallInSewer
			)
			(gContinuousMusic stop: number: 24 loop: 1 priority: 12 play:)
			(switch (gEgo onControl: 1)
				(4
					(fallInSewer changeState: 1)
				)
				(8
					(fallInSewer changeState: 2)
				)
				(16
					(fallInSewer changeState: 3)
				)
				(32
					(fallInSewer changeState: 4)
				)
			)
		)
		(super doit:)
	)
)

(instance fallInSewer of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(= temp0 (gCurRoom picture:))
		(switch (= state newState)
			(1
				(cond
					((and (!= temp0 204) (!= temp0 201))
						(= local100 10)
					)
					((<= (gEgo y:) 100)
						(= local100 20)
					)
					(else
						(= local100 45)
					)
				)
				(self changeState: 5)
			)
			(2
				(cond
					((and (!= temp0 200) (!= temp0 203))
						(= local100 -20)
					)
					((<= (gEgo y:) 100)
						(= local100 -30)
					)
					(else
						(= local100 -45)
					)
				)
				(gEgo setLoop: 5)
				(self changeState: 5)
			)
			(3
				(cond
					((or (== temp0 200) (== temp0 203))
						(= local100 -15)
					)
					((or (== temp0 201) (== temp0 204))
						(= local100 15)
					)
				)
				(= local101 -2)
				(self changeState: 5)
			)
			(4
				(cond
					((or (== temp0 200) (== temp0 203))
						(= local100 20)
					)
					((or (== temp0 201) (== temp0 204))
						(= local100 -20)
					)
				)
				(= local101 20)
				(self changeState: 5)
			)
			(5
				(gEgo
					view: 99
					setCel: 0
					setMotion:
						MoveTo
						(+ (gEgo x:) local100)
						(+ (gEgo y:) local101)
					setCycle: CT 9 1 self
				)
			)
			(6
				(gEgo hide:)
				(= cycles 60)
			)
			(7
				(EgoDead
					{ Falling into the trough of human waste, you lose consciousness as you slip beneath the surface.}
				)
			)
		)
	)
)

(instance asphyxiation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global139 1)
				(gEgo view: 298 loop: 5 cel: 0 findPosn: setCycle: End self)
			)
			(1
				(Print 205 36) ; "Just before losing consciousness, while slumping to the floor, you realize..."
				(Print 205 37) ; "Oh no! It's..It's..methane gas."
				(EgoDead
					{You die from asphyxiation in a pocket of methane gas. Next time, avoid this area or ...?}
				)
			)
		)
	)
)

(instance explodeSound of Sound
	(properties
		number 30
	)
)

(instance pBoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(Load rsPIC 300)
				(Load rsSOUND 30)
				(gSounds eachElementDo: #dispose)
				(DrawPic 300 6)
				(gCast eachElementDo: #hide)
				(explodeSound play:)
				(RedrawCast)
				(ShakeScreen 10)
				(DrawPic (gCurRoom picture:))
				(gAddToPics eachElementDo: #doit)
				(gCast eachElementDo: #show)
				(gEgo view: 298 loop: 2 cel: 0 findPosn: setCycle: Fwd)
				(RedrawCast)
				(Wait 80)
				(EgoDead
					{You're fried! The spark from your gunfire in explosive gas is VERY fatal.}
				)
			)
		)
	)
)

