;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	Room43 0
)

(synonyms
	(dolphin dolphin)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
)

(instance wave1 of Prop
	(properties)
)

(instance wave2 of Prop
	(properties)
)

(instance wave3 of Prop
	(properties)
)

(instance wave4 of Prop
	(properties)
)

(instance wave5 of Prop ; UNUSED
	(properties)
)

(instance wave6 of Prop ; UNUSED
	(properties)
)

(instance waves of List
	(properties)
)

(instance Room43 of Rm
	(properties)

	(method (init)
		(if gNight
			(= picture 143)
		else
			(= picture 43)
		)
		(= south (= north (= west (= east 31))))
		(= horizon 78)
		(= gIndoors 0)
		(= global108 horizon)
		(super init:)
		(Load rsVIEW 312)
		(Load rsVIEW 311)
		(Load rsVIEW 310)
		(Load rsVIEW 306)
		(Load rsVIEW 320)
		(Load rsVIEW 321)
		(Load rsVIEW 15)
		(Load rsVIEW 524)
		(Load rsVIEW 670)
		(Load rsVIEW 518)
		(Load rsSOUND 76)
		(self setRegions: 501 504) ; waterReg, Gull_Region
		(wave1
			isExtra: 1
			view: 670
			loop: 0
			cel: 0
			posn: 50 143
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			cycleSpeed: 2
			init:
		)
		(wave2
			isExtra: 1
			view: 670
			loop: 1
			cel: 2
			posn: 151 175
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			cycleSpeed: 2
			init:
		)
		(wave3
			isExtra: 1
			view: 670
			loop: 2
			cel: 0
			posn: 284 184
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			cycleSpeed: 2
			init:
		)
		(wave4
			isExtra: 1
			view: 670
			loop: 3
			cel: 2
			posn: 301 146
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			cycleSpeed: 2
			init:
		)
		(waves add: wave1 wave2 wave3 wave4)
		(wave1 setScript: waveActions)
		(if (or (gEgo has: 27) (gEgo has: 24)) ; Silver_Whistle, Dead_Fish
			(= local11 1)
		)
		(cond
			((and (== global136 101) (== global137 100))
				(gEgo posn: 13 92)
			)
			((and (== global136 99) (== global137 100))
				(gEgo posn: 294 85)
			)
			((and (== global136 100) (== global137 99))
				(gEgo posn: 38 172)
			)
			((and (== global136 100) (== global137 101))
				(gEgo posn: (gEgo x:) (+ horizon (gEgo yStep:) 1))
			)
		)
		(= local9 (Prop new:))
		(local9 setScript: deathTimer init: hide:)
		(= local10 (Prop new:))
		(local10 init: hide:)
		(if ((Inv at: 27) ownedBy: 207) ; Silver_Whistle
			(= local4 (Act new:))
			(local4
				ignoreHorizon:
				posn: 118 74
				view: 320
				loop: 0
				setPri: 7
				illegalBits: 0
				ignoreActors:
				setCycle: Fwd
				cycleSpeed: 1
				xStep: 5
				yStep: 4
				init:
			)
			(local4 setScript: pelActions)
		)
		(gEgo view: 8 setScript: bridleActions init:)
	)

	(method (dispose)
		(gTimers eachElementDo: #dispose 192)
		(gSounds eachElementDo: #dispose)
		(waves dispose:)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look[<around][/room]')
					(Print 43 0) ; "You have found yourself stranded upon a desert island. Also, it seems, have others before you. Now, what are you going to do, Rosella?!"
				)
				((Said 'bathe')
					(cond
						((== (gEgo view:) 2)
							(Print 43 1) ; "Just enter the water."
						)
						((== (gEgo view:) 8)
							(Print 43 2) ; "You're already swimming."
						)
						(
							(or
								(== (gEgo view:) 5)
								(== (gEgo view:) 6)
								(== (gEgo view:) 7)
							)
							(Print 43 3) ; "Just go deeper."
						)
						(else
							(Print 43 4) ; "Just go and do it."
						)
					)
				)
				((Said 'get,drink[/drink,water]')
					(cond
						((!= global105 0)
							(Print 43 5) ; "YUCK!! This water's too salty!"
						)
						(
							(or
								(& (= local14 (NearControl gEgo 12)) $0008)
								(& local14 $0800)
								(& local14 $0002)
								(& local14 $0200)
							)
							(= global164 (gEgo script:))
							(gEgo setScript: drinking)
							(drinking changeState: 1)
						)
						(else
							(Print 800 1) ; "You're not close enough."
						)
					)
				)
				((Said 'fish')
					(Print 43 6) ; "You don't see any fish here."
				)
				((Said 'get,capture/fish')
					(Print 43 6) ; "You don't see any fish here."
				)
				((Said 'look,find/tamir')
					(Print 43 7) ; "You can't see it from here."
				)
				((Said 'look>')
					(cond
						((Said '/fish')
							(if (gEgo has: 24) ; Dead_Fish
								((Inv at: 24) showSelf:) ; Dead_Fish
							else
								(Print 43 6) ; "You don't see any fish here."
							)
						)
						((Said '/dolphin')
							(cond
								((gCast contains: local6)
									(Print 43 8) ; "A bottle-nose dolphin pokes its nose out of the water and chatters noisily."
								)
								((== (gEgo view:) 312)
									(Print 43 9) ; "You can feel the dolphin's strong muscles working, as it swims through the ocean with you on its back."
								)
								(else
									(Print 43 10) ; "You don't see one here."
								)
							)
						)
						((Said '/island')
							(Print 43 11) ; "The small island is nothing more than a sand bar, decorated with two lonely palm trees...and various shipwrecks."
						)
						((Said '<under/water,ocean')
							(if (== (gEgo view:) 2)
								(Print 43 12) ; "You're not in the water."
							else
								(Print 43 13) ; "You look under the water, and see nothing but...more water."
							)
						)
						((Said '/ocean,water')
							(Print 43 14) ; "The blue ocean surrounds this small island. You look in all directions, but can see no sign of land."
						)
						((Said '/beach')
							(Print 43 15) ; "In this case, the beach and the island are one and the same!"
						)
						((or (Said '/dirt') (Said '<down'))
							(cond
								(
									(and
										(gEgo inRect: 218 107 254 116)
										((Inv at: 21) ownedBy: 43) ; Golden_Bridle
									)
									(gGame changeScore: 3)
									(bridleActions changeState: 1)
								)
								((gCast contains: local8)
									(Print 43 16) ; "You see a shiny whistle lying on the ground."
								)
								(else
									(Print 43 17) ; "You look at the ground and see nothing but sand."
								)
							)
						)
						((Said '/forest,flora,palm')
							(Print 43 18) ; "Only one lonely palm grows here."
						)
						((Said '/coconut')
							(Print 43 19) ; "You don't see any coconuts."
						)
						((Said '/boat,shipwreck')
							(Print 43 20) ; "It looks as if many an unlucky sailor has been stranded here."
						)
						((Said '/pelican,bird')
							(if (!= local1 4)
								(Print 43 21) ; "A pelican visits you on this desert island."
							else
								(Print 43 22) ; "You don't see it here."
							)
						)
					)
				)
				((Said 'climb/forest,palm')
					(Print 43 23) ; "It is difficult to climb trees while wearing that dress!"
				)
				((Said 'give,throw,feed/fish')
					(if (gEgo has: 24) ; Dead_Fish
						(if (== (gEgo view:) 2)
							(switch local1
								(1
									(if (< (gEgo distanceTo: local4) 80)
										(if (> (gEgo x:) 121)
											(gGame changeScore: 4)
											(pelActions changeState: 20)
										else
											(Print 43 24) ; "Try doing that somewhere else."
										)
									else
										(Print 800 1) ; "You're not close enough."
									)
								)
								(2
									(Print 43 25) ; "Not while the pelican is flying."
								)
								(3
									(Print 43 26) ; "You've already done that."
								)
								(else
									(Print 43 27) ; "You can't do that now."
								)
							)
						else
							(Print 43 27) ; "You can't do that now."
						)
					else
						(Print 43 28) ; "You don't have one."
					)
				)
				((Said 'get,whistle/whistle')
					(cond
						(((Inv at: 27) ownedBy: 43) ; Silver_Whistle
							(if (< (gEgo distanceTo: local8) 15)
								(bridleActions changeState: 10)
								(gGame changeScore: 2)
								(gEgo get: 27) ; Silver_Whistle
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((gEgo has: 27) ; Silver_Whistle
							(Print 43 29) ; "You already have it."
						)
						(else
							(Print 43 10) ; "You don't see one here."
						)
					)
				)
				((Said 'mount/dolphin')
					(if (gCast contains: local6)
						(if (< (gEgo distanceTo: local6) 14)
							(gGame changeScore: 2)
							(dolphActions changeState: 10)
						else
							(Print 800 1) ; "You're not close enough."
						)
					else
						(Print 43 30) ; "How can you do that?"
					)
				)
				((Said 'play,whistle,blow[/whistle]')
					(if (gEgo has: 27) ; Silver_Whistle
						(gSounds eachElementDo: #dispose)
						((Sound new:) number: 76 loop: 1 play:)
						(if (not local6)
							(if (== global217 0)
								(gGame changeScore: 2)
								(= global217 1)
							)
							(= local6 (Act new:))
							(gCurRoom setScript: dolphActions)
						else
							(Print 43 31) ; "Okay. TWEEEEEEEEEEEET!"
						)
					else
						(Print 43 32) ; "You don't have it."
					)
				)
				((Said 'talk>')
					(cond
						(
							(and
								(local4 inRect: 0 0 319 189)
								(Said '[/pelican,bird]')
							)
							(Print 43 33) ; "You feel silly trying to talk to a pelican!"
							(event claimed: 1)
						)
						((and (gCast contains: local6) (Said '[/dolphin]'))
							(Print 43 34) ; "You speak to the dolphin, and it chatters back."
							(event claimed: 1)
						)
						((Said '/bird,gull,gull')
							(event claimed: 0)
						)
						((Said '[/!*]')
							(Print 43 35) ; "To whom?"
						)
					)
				)
				((Said 'feed/pelican,bird')
					(if (and (gCast contains: local4) (!= local1 4))
						(Print 43 36) ; "Feed it what?"
					else
						(Print 43 10) ; "You don't see one here."
					)
				)
				((Said 'get/pelican,bird')
					(if (and (gCast contains: local4) (!= local1 4))
						(Print 43 37) ; "You would have to catch the pelican first."
					else
						(Print 43 10) ; "You don't see one here."
					)
				)
				((Said 'capture/pelican,bird')
					(if (and (gCast contains: local4) (!= local1 4))
						(Print 43 38) ; "You can try."
					else
						(Print 43 10) ; "You don't see one here."
					)
				)
				((Said 'kiss')
					(cond
						((and (gCast contains: local4) (!= local1 4))
							(Print 43 38) ; "You can try."
						)
						((gCast contains: local6)
							(Print 43 39) ; "There is no need for that."
						)
						(else
							(event claimed: 0)
						)
					)
				)
				((Said 'give>')
					(if (= temp0 (gInventory saidMe:))
						(if (gEgo has: (gInventory indexOf: temp0))
							(cond
								(
									(or
										(and
											(!= local1 4)
											(gCast contains: local4)
										)
										(Said '/pelican,bird')
									)
									(Print 43 40) ; "The pelican has no interest in it."
								)
								(
									(and
										(gCast contains: local6)
										(Said '/dolphin')
									)
									(Print 43 41) ; "The dolphin has no interest in it."
								)
								(else
									(Print 43 42) ; "Please be more specific."
									(event claimed: 1)
								)
							)
						else
							(DontHave) ; "You don't have it."
						)
					)
				)
				((Said 'get,capture/dolphin')
					(cond
						((gCast contains: local6)
							(Print 43 43) ; "You can't "get" the dolphin. You could try riding it."
						)
						((== (gEgo view:) 312)
							(Print 43 44) ; "You are RIDING the dolphin!"
						)
						(else
							(Print 43 10) ; "You don't see one here."
						)
					)
				)
				((Said 'give>')
					(if
						(and
							(= temp0 (gInventory saidMe:))
							(gEgo has: (gInventory indexOf: temp0))
						)
						(Print 43 45) ; "The dolphin doesn't want anything."
					else
						(Print 43 46) ; "You don't have that."
					)
				)
				((Said 'pat/dolphin')
					(if (gCast contains: local6)
						(if (< (gEgo distanceTo: local6) 12)
							(Print 43 47) ; "The dolphin's skin feels smooth and slippery as you pet it."
						else
							(Print 800 1) ; "You're not close enough."
						)
					else
						(Print 43 10) ; "You don't see one here."
					)
				)
			)
		)
	)
)

(instance bridleActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo get: 21 setMotion: 0) ; Golden_Bridle
				(= local0 (gEgo viewer:))
				(gEgo viewer: 0 view: 21 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(= global182 1)
				(gEgo setCycle: Beg self)
			)
			(3
				(Print 43 48 #at -1 20) ; "You look at the ground inside the wrecked boat. What is this?! Why, it's a golden bridle! You pick it up and carry it with you."
				(gEgo viewer: local0 view: 2 setCycle: Walk)
				(HandsOn)
			)
			(10
				(HandsOff)
				(= local0 (gEgo viewer:))
				(LookAt gEgo local8)
				(gEgo viewer: 0 view: 21 loop: 1 cel: 0 setCycle: End self)
			)
			(11
				(local8 dispose:)
				(local7 dispose:)
				(= global182 1)
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo viewer: local0 view: 2 setCycle: Walk)
				(HandsOn)
			)
		)
	)
)

(instance pelActions of Script
	(properties)

	(method (doit)
		(if (and (== local1 1) (gEgo inRect: 95 92 140 110))
			(pelActions changeState: 10)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: local4)
					(= local1 1)
					(local10 setScript: pelMovement)
					((ScriptID 0 5) setReal: self 30) ; timer2
				)
			)
			(1
				(self changeState: 10)
			)
			(10
				((ScriptID 0 5) dispose: delete:) ; timer2
				(++ local2)
				(local10 setScript: 0)
				(= local1 2)
				(local4
					view: 321
					setLoop: 2
					setCel: -1
					cel: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(11
				(local4
					setLoop: 0
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 339 20 self
				)
			)
			(12
				(local4 stopUpd:)
				(= local1 4)
				((ScriptID 0 5) setReal: self 1 1) ; timer2
			)
			(13
				(if (and (not (gEgo inRect: 192 108 237 125)) (< local2 3))
					(= local1 2)
					(local4
						startUpd:
						posn: -20 20
						setCycle: Fwd
						setMotion: MoveTo 118 74 self
					)
				else
					(self changeState: 11)
				)
			)
			(14
				(local4 loop: 1 cel: 0 setCycle: End self)
			)
			(15
				(local4 view: 320 setLoop: 0 cycleSpeed: 1 setCycle: Fwd)
				(= local1 1)
				(local10 setScript: pelMovement)
			)
			(20
				(HandsOff)
				(if (IsObject (ScriptID 0 5)) ; timer2
					((ScriptID 0 5) dispose: delete:) ; timer2
				)
				((Sound new:) number: 63 play:)
				(local10 setScript: 0)
				(= local1 3)
				(LookAt gEgo local4)
				(= local0 (gEgo viewer:))
				(gEgo viewer: 0 loop: (& (gEgo loop:) $0001))
				(gEgo
					view: 15
					cel: 0
					setMotion: 0
					loop: (& (gEgo loop:) $0001)
					setCycle: End self
				)
			)
			(21
				(= local5 (Act new:))
				(if (gEgo loop:)
					(local5 posn: (- (gEgo x:) 10) (- (gEgo y:) 15) init:)
				else
					(local5 posn: (+ (gEgo x:) 10) (- (gEgo y:) 15) init:)
				)
				(local5
					view: 306
					ignoreActors:
					illegalBits: 0
					ignoreHorizon:
					setPri: 6
					setLoop: 0
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo (+ (local4 x:) 8) (- (local4 y:) 7) self
				)
				(gEgo viewer: local0 view: 2 setCycle: Walk)
				(local4 setLoop: 1 setCel: -1 cel: 0 setCycle: End)
			)
			(22
				(= local8 (Act new:))
				(local8 setScript: whistleActions)
				(local8
					posn: 123 64
					ignoreActors:
					illegalBits: 0
					view: 524
					setLoop: 0
					cel: 0
					setMotion: MoveTo 137 106 whistleActions
					yStep: 10
					setCycle: Fwd
					init:
				)
				(local4 setLoop: 2 cel: 0 setCycle: End self)
				(local5 dispose:)
				((Inv at: 27) moveTo: 43) ; Silver_Whistle
			)
			(23
				(Print 43 49) ; "You throw the stinky, dead fish to the pelican. Greedily, he catches it in his large bill. As he does so, you notice something shiny fall from his bill, onto the ground."
				((Inv at: 24) moveTo: 207) ; Dead_Fish
				(= local2 99)
				(HandsOn)
				(self changeState: 10)
			)
		)
	)
)

(instance whistleActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(local8 setCel: 0 setLoop: 1 setCycle: 0 stopUpd:)
				(= local7 (Prop new:))
				(local7
					view: 518
					setLoop: 4
					ignoreActors:
					posn: (local8 x:) (local8 y:)
					init:
				)
				(self changeState: 2)
			)
			(2
				(local7 cel: 0 setCycle: End self show:)
			)
			(3
				(local7 hide:)
				(= seconds (Random 3 10))
			)
			(4
				(self changeState: 2)
			)
		)
	)
)

(instance dolphActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(gSounds eachElementDo: #dispose)
				(= local13 (Sound new:))
				(local13 number: 35 loop: 1 play:)
				(local6
					posn: 284 72
					view: 310
					loop: 0
					cel: 0
					ignoreHorizon:
					setCycle: End self
					init:
				)
			)
			(2
				(local6 view: 311 posn: 283 88 loop: 3 setCycle: Fwd)
				(Print 43 50) ; "You put the shiny, silver whistle to your lips and forcefully blow into it, producing a loud TWEEEEEEEEEEET! To your astonishment, a friendly dolphin appears just off-shore and jabbers excitedly at you."
			)
			(10
				(local6 dispose:)
				(= global105 14)
				(gEgo
					view: 312
					loop: 0
					setCycle: Fwd
					setMotion: MoveTo 339 (gEgo y:)
				)
			)
		)
	)
)

(instance deathTimer of Script
	(properties)

	(method (doit)
		(if
			(and
				local12
				(<= state 2)
				(or
					(gEgo inRect: 140 98 201 156)
					(gEgo inRect: 197 119 269 148)
				)
			)
			(self changeState: 10)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local11
					((ScriptID 0 4) setReal: self 1 4) ; timer1
				else
					((ScriptID 0 4) setReal: self 1 2) ; timer1
				)
			)
			(1
				(= local12 1)
			)
			(10
				(HandsOff)
				(gEgo
					illegalBits: $fffe
					setAvoider: Avoid
					setMotion: MoveTo 184 130 self
				)
			)
			(11
				(gEgo
					setMotion: 0
					viewer: 0
					view: 21
					loop: 2
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(12
				(gEgo view: 83 loop: 0 cel: 0)
				((ScriptID 0 4) setReal: self 4) ; timer1
			)
			(13
				(gEgo cel: 1)
				((ScriptID 0 4) setReal: self 5) ; timer1
			)
			(14
				(gEgo cel: 2)
				((ScriptID 0 4) setReal: self 6) ; timer1
			)
			(15
				(gEgo cel: 3)
				((ScriptID 0 4) setReal: self 7) ; timer1
			)
			(16
				(Print 43 51 #at -1 20) ; "It looks like exposure and thirst have done you in, Rosella."
				((ScriptID 0 4) setReal: self 6) ; timer1
			)
			(17
				(= gDeathFlag 1)
			)
		)
	)
)

(instance waveActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(for ((= local16 0)) (< local16 (waves size:)) ((++ local16))
					((View new:)
						view: ((waves at: local16) view:)
						loop: ((waves at: local16) loop:)
						cel: 0
						setPri: 0
						ignoreActors:
						x: ((waves at: local16) x:)
						y: ((waves at: local16) y:)
						init:
						addToPic:
						yourself:
					)
				)
				(= local16 0)
				(self changeState: 1)
				(self changeState: 1)
			)
			(1
				((waves at: local16) cel: 0 show: setCycle: End self)
			)
			(2
				((waves at: local16) hide:)
				(if (< local16 (- (waves size:) 1))
					(++ local16)
				else
					(= local16 0)
				)
				(waveActions changeState: 1)
			)
		)
	)
)

(instance drinking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(= local0 (gEgo viewer:))
				(gEgo viewer: 0 view: 21 cel: 0 setCycle: End self)
			)
			(2
				(= global120 (Print 43 5 #at -1 20 #dispose)) ; "YUCK!! This water's too salty!"
				(Timer setReal: self 5)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo view: 2 setCycle: Walk)
				(gEgo script: global164 viewer: local0)
				(HandsOn)
			)
		)
	)
)

(instance pelMovement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local1 1)
					(local4 setCycle: Fwd)
				)
				(= seconds (Random 3 7))
			)
			(1
				(if (== local1 1)
					(local4 setCycle: 0)
					(= seconds (Random 3 7))
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

