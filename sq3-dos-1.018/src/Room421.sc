;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 421)
(include sci.sh)
(use Main)
(use Interface)
(use Chase)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room421 0
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
)

(instance deathSound of Sound
	(properties)
)

(instance elevator of Act
	(properties)
)

(instance elevTop of Prop
	(properties)
)

(instance elevBottom of Prop
	(properties)
)

(instance cable1 of Prop
	(properties)
)

(instance cable2 of View
	(properties)
)

(instance gear of Prop
	(properties)
)

(instance pulley1 of Act
	(properties)
)

(instance pulley2 of Act
	(properties)
)

(instance Room421 of Rm
	(properties
		picture 421
		vanishingY -400
	)

	(method (init)
		(super init:)
		(= local8 500)
		(= local4 1)
		(Load rsVIEW 94)
		(Load rsVIEW 777)
		(Load rsVIEW 119)
		(Load rsVIEW 108)
		(Load rsVIEW 106)
		(Load rsVIEW 120)
		(Load rsSOUND 91)
		(Load rsSOUND 92)
		(gEgo init:)
		(if (== global117 421)
			(= local0 5)
			(= global111 (View new:))
			(global111
				view: 120
				setLoop: 4
				setCel: 6
				setPri: 0
				posn: 160 127
				init:
				stopUpd:
			)
		)
		(if (IsItemAt 16 421) ; Invisibility_Belt
			(= gView (View new:))
			(gView
				view: 120
				loop: 5
				cel: 0
				posn: 157 124
				setPri: 1
				init:
				stopUpd:
			)
		)
		(gear
			view: 120
			loop: 0
			posn: 158 65
			ignoreActors:
			setCycle: Fwd
			setScript: gearActions
			init:
		)
		(gLongSong number: 85 loop: -1 play:)
		(pulley1
			view: 120
			setLoop: 1
			setCel: 1
			ignoreActors:
			illegalBits: 0
			ignoreHorizon:
			posn: 77 -23
			setPri: 0
			init:
			stopUpd:
		)
		(pulley2
			view: 120
			setLoop: 1
			illegalBits: 0
			ignoreHorizon:
			ignoreActors:
			setCel: 1
			posn: 108 0
			setPri: 15
			init:
			stopUpd:
		)
		(gEgo
			view: 83
			loop: 2
			cel: 2
			posn: 56 202
			setPri: 8
			setLoop: 2
			setCel: 2
			ignoreActors:
			illegalBits: 0
			init:
		)
		(cable1
			view: 83
			loop: 3
			cel: 9
			ignoreActors:
			posn: 56 83
			setPri: 7
			cycleSpeed: 5
			init:
			stopUpd:
		)
		(cable2
			view: 83
			loop: 3
			cel: 0
			ignoreActors:
			posn: 56 71
			setPri: 7
			init:
			stopUpd:
		)
		(gCurRoom setScript: raise)
	)

	(method (newRoom newRoomNumber)
		(gSounds eachElementDo: #fade)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (and (& (gEgo onControl: 0) $0004) (not gHandsOff))
			(= global104 7)
			(if (and (gCast contains: global111) (< local0 5))
				(global111 setMotion: 0)
			)
			(pulley1 setScript: smash)
		)
		(if
			(and
				(& (gEgo onControl: 0) $1000)
				(== global104 2)
				(== local1 0)
				(<= (bringOnFester state:) 0)
			)
			(pulley1 setScript: fall)
		)
		(cond
			((== global104 1)
				(gEgo setPri: 8)
			)
			((and (== global104 2) (gEgo inRect: 0 135 91 163))
				(gEgo setPri: 14)
			)
			(
				(and
					(== global104 2)
					(gEgo inRect: 266 140 303 147)
					(not gHandsOff)
				)
				(= global104 3)
				(gEgo setPri: 10 ignoreControl: 16384 observeControl: 8192)
			)
			(
				(and
					(== global104 3)
					(gEgo inRect: 268 148 308 154)
					(not gHandsOff)
				)
				(= global104 2)
				(gEgo setPri: -1 observeControl: 16384 ignoreControl: 8192)
			)
			(
				(and
					(== global104 3)
					(not gHandsOff)
					(gEgo inRect: 239 52 270 57)
				)
				(= global104 4)
				(gEgo setPri: -1 observeControl: 16384 ignoreControl: 8192)
				(if (and (or (== global110 1) (== global110 2)) (== local0 0))
					(self setScript: termComesUp)
				)
			)
			(
				(and
					(== global104 4)
					(gEgo inRect: 239 57 272 64)
					(not gHandsOff)
				)
				(= global104 3)
				(gEgo setPri: 10 ignoreControl: 16384 observeControl: 8192)
			)
			((== global104 3)
				(gEgo setPri: 10)
			)
			(
				(and
					(== global104 4)
					(gEgo inRect: 0 62 252 76)
					(not gHandsOff)
				)
				(gEgo setPri: 14)
			)
			(
				(and
					(== global104 4)
					(& (gEgo onControl: 0) $0200)
					(not gHandsOff)
				)
				(gEgo setPri: 9)
			)
			((not gHandsOff)
				(gEgo setPri: -1)
			)
		)
		(cond
			((and (== local0 4) (global111 inRect: 0 62 237 76))
				(global111 setPri: 14)
			)
			((and (== local0 2) (global111 inRect: 0 136 91 163))
				(global111 setPri: 14)
			)
			((and (!= global110 3) (== local0 4) (global111 setPri: -1)))
			((== local0 3)
				(global111 setPri: 10)
			)
			((and (== local0 4) (& (global111 onControl: 0) $0200))
				(global111 setPri: 9)
			)
			((== local0 4)
				(global111 setPri: -1)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look,talk/blatz')
					(if (== (gCurRoom script:) bringOnFester)
						(cond
							((== local1 1)
								(Print 421 0) ; "Fester is riding up on the elevator."
							)
							((== local1 2)
								(Print 421 1) ; "Fester is waiting impatiently for you to get on the elevator."
							)
							(else
								(Print 421 2) ; "You don't see him here."
							)
						)
					else
						(Print 421 2) ; "You don't see him here."
					)
				)
				((Said 'look>')
					(cond
						(
							(or
								(Said '/area')
								(Said '/around')
								(Said '[<around][/!*]')
							)
							(Print 421 3) ; "You are within the cavernous interior of Mog's belly. An elevator shaft leads down, and stairs run between the first and second level platforms. The heavy equipment necessary to automate Mog can be seen on the upper level."
						)
						((Said '/stair')
							(Print 421 4) ; "They look just like stairs to me."
						)
						((Said '/pedestal')
							(Print 421 5) ; "The platform flooring is made up of a metalic mesh."
						)
						((Said '<down')
							(Print 421 6) ; "Through the metal grating, you can make out steel girders leading down into the darkness."
						)
						((or (Said '<up') (Said '/ceiling'))
							(Print 421 7) ; "Looking up, you see girders and various pieces of machinery fading off into the darkness."
						)
						((Said '/android')
							(cond
								((== local0 0)
									(Print 421 8) ; "You are within the interior of a giant robot-like statue."
								)
								((== local0 1)
									(Print 421 9) ; "You see a lean, mean, fighting machine coming up elevator."
								)
								((and (>= local0 2) (!= local0 5) (!= local0 6))
									(Print 421 10) ; "It looks like 750 pounds of fighting robot is headed your way."
								)
								((== local0 5)
									(if
										(and
											(== global104 2)
											(<=
												(gEgo distanceTo: global111)
												30
											)
										)
										(Print
											(Format ; "The terminator is now a pile of junk on the first level platform. %s"
												@global402
												421
												11
												(if (IsItemAt 16 421) ; Invisibility_Belt
													{Looking closely, you notice that the terminator's invisibility belt has survived relatively intact.}
												else
													{}
												)
											)
										)
									else
										(Print 421 12) ; "The terminator is now a pile of junk on the first level platform."
									)
								)
							)
						)
						((and (Said '/debris') (== local0 5))
							(if
								(and
									(== global104 2)
									(<= (gEgo distanceTo: global111) 30)
								)
								(Print
									(Format ; "The terminator is now a pile of junk on the first level platform. %s"
										@global402
										421
										11
										(if (IsItemAt 16 421) ; Invisibility_Belt
											{Looking closely, you notice that the terminator's invisibility belt has survived relatively intact.}
										else
											{}
										)
									)
								)
							else
								(Print 421 12) ; "The terminator is now a pile of junk on the first level platform."
							)
						)
						((Said '/engine,device,equipment')
							(Print 421 13) ; "The large electric motor providing power for Mog's automation hums noisily away on the second level platform."
						)
						((Said '/cog')
							(Print 421 14) ; "It appears that the gears provide the power linkage for the machinery moving Mog's arms and jaw. It seems that they haven't heard of OSHA here on Phleebhut. There isn't even a guard rail around them. I sure wouldn't want to fall in there!"
						)
						((Said '/rope,scout,pulley,jar')
							(Print 421 15) ; "There are two rope pulleys near the motor and gears. Apparently they are used for maintenance of the equipment. Looking up, you notice that they are mounted on tracks running the length of the second floor platform."
						)
						((Said '/banister')
							(Print 421 16) ; "The two rope pulleys are mounted on the tracks."
						)
						((Said '/overhang')
							(Print 421 17) ; "Nuts to you!"
						)
						((Said '/pit')
							(Print 421 18) ; "The unguarded elevator shaft runs down to the entrance below. I wonder how many tourists they lose falling down there every year. I hope Fester has good liability insurance."
						)
						((Said '/bolt')
							(Print 421 19) ; "Steel girders provide the structural support for the statue and equipment."
						)
						((Said '/elevator')
							(if (or (== local1 2) (== local1 1))
								(Print 421 20) ; "Yes, that's an elevator."
							else
								(Print 421 21) ; "You don't see one here."
							)
						)
						((Said '/button,control')
							(if
								(and
									(gEgo inRect: 0 37 73 133)
									(== global104 2)
								)
								(Print 421 22) ; "Gee, button one says "Up" and one says "Down"."
							else
								(Print 421 23) ; "You're not close enough."
							)
						)
					)
				)
				((and (Said 'explore/android,debris,body') (== local0 5))
					(if
						(and
							(== global104 2)
							(<= (gEgo distanceTo: global111) 30)
						)
						(Print
							(Format ; "The terminator is now a pile of junk on the first level platform. %s"
								@global402
								421
								11
								(if (IsItemAt 16 421) ; Invisibility_Belt
									{Looking closely, you notice that the terminator's invisibility belt has survived relatively intact.}
								else
									{}
								)
							)
						)
					else
						(Print 421 12) ; "The terminator is now a pile of junk on the first level platform."
					)
				)
				((or (Said 'press<up') (Said 'press/button<up'))
					(if (gEgo inRect: 39 123 62 133)
						(Print 421 24) ; "Nothing happens."
					else
						(NotClose) ; "It's not quite within reach."
					)
				)
				(
					(or
						(Said 'press/button')
						(Said 'press<down')
						(Said 'use/elevator')
					)
					(if (and (gEgo inRect: 39 123 63 133) (== local1 2))
						(Print 421 25) ; "OK"
						(gCurRoom setScript: lowerEgoElevator)
					else
						(NotClose) ; "It's not quite within reach."
					)
				)
				((Said 'talk/android')
					(if (gCast contains: global111)
						(Print 421 26) ; "I don't think he's interested in talking."
					else
						(Print 421 27) ; "You don't see anyone here to talk to."
					)
				)
				((Said 'board,pull,hold/scout,rope,jar')
					(Print 421 28) ; "That wouldn't do much good."
				)
				((Said 'swing,get,press,use/scout,pulley,rope,jar')
					(switch local3
						(0
							(gEgo setScript: doPulley)
						)
						(2
							(Print 421 29) ; "There's no need for that now."
						)
						(else
							(Print 421 30) ; "Not now."
						)
					)
				)
				((Said 'get/scout,banister,rope')
					(Print 421 31) ; "There's no way you could do that."
				)
				((Said 'get/belt')
					(cond
						((gEgo has: 16) ; Invisibility_Belt
							(Print 421 32) ; "You already took it."
						)
						((not (IsItemAt 16 421)) ; Invisibility_Belt
							(Print 421 33) ; "You don't seen one here."
						)
						((> (gEgo distanceTo: gView) 12)
							(NotClose) ; "It's not quite within reach."
						)
						(else
							(Print 421 34) ; "Ok."
							(gView dispose:)
							(gGame changeScore: 35)
							(if (> (bringOnFester seconds:) 5)
								(bringOnFester seconds: 5)
							)
							(gEgo get: 16) ; Invisibility_Belt
						)
					)
				)
				((Said 'get/android')
					(if (== local0 5)
						(Print 421 35) ; "There is no way you could carry all that."
					else
						(Print 421 36) ; "No way!"
					)
				)
				((Said 'get<in/elevator')
					(Print 421 37) ; "Just go there."
				)
				((Said 'kill/android')
					(Print 421 38) ; "That's nice in theory, but you'd need to find some way to put it into practice."
				)
				((Said 'use/orat,stick')
					(Print 421 39) ; "That wouldn't help any."
				)
				((Said 'jump')
					(Print 421 40) ; "You would have a better chance of surviving if you took the elevator."
				)
				((Said 'turn<off/engine')
					(Print 421 41) ; "You have no way of doing that."
				)
				((Said 'climb')
					(Print 421 42) ; "You really are not all that fond of heights."
				)
				((Said '/scout,jar,rope,cog,device,engine')
					(Print 421 43) ; "That wouldn't accomplish much."
				)
			)
		)
		(if
			(and
				(== (event type:) evKEYBOARD)
				(== (event message:) KEY_RETURN)
				(== (gCurRoom script:) bringOnFester)
				(<= 2 (bringOnFester state:) 4)
			)
			(cls)
			(bringOnFester seconds: 0)
			(bringOnFester cue:)
		)
	)
)

(instance raise of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global104 1)
				(gEgo setMotion: MoveTo 56 83 self)
				(cable1 setCycle: Beg)
			)
			(1
				(HandsOn)
				(elevTop
					view: 83
					setLoop: 2
					cel: 1
					posn: 56 85
					setPri: 10
					ignoreActors:
					init:
					stopUpd:
				)
				(elevBottom
					view: 83
					setLoop: 2
					cel: 0
					posn: 56 85
					setPri: 8
					ignoreActors:
					init:
					stopUpd:
				)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					illegalBits: $8000
					observeControl: 16384
					posn: 56 129
					setPri: -1
				)
				(= global104 2)
				(= local1 2)
			)
		)
	)
)

(instance termComesUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(= local1 1)
				(gEgo observeControl: 4096)
				(elevator
					view: 83
					setLoop: 2
					setCel: 4
					posn: 56 (elevTop y:)
					illegalBits: 0
					ignoreActors:
					setPri: 8
					setMotion: MoveTo 56 202 self
					init:
				)
				(cable1
					view: 83
					ignoreActors:
					posn: 56 83
					loop: 3
					cel: 255
					cycleSpeed: 5
					setCycle: End
				)
				(elevTop view: 777 forceUpd:)
				(elevBottom view: 777 forceUpd:)
			)
			(1
				(elevator setCel: 3 setMotion: MoveTo 56 83 self)
				(cable1 cel: 9 setCycle: Beg)
			)
			(2
				(elevator dispose:)
				(elevTop view: 83 setLoop: 2 setCel: 1)
				(elevBottom view: 83 setLoop: 2 setCel: 0)
				(cable1 view: 777 stopUpd:)
				(= global111 (Act new:))
				(global111
					view: 119
					posn: 64 128
					loop: 0
					setCycle: Walk
					setAvoider: Avoid
					setMotion: MoveTo 89 128 self
					init:
				)
			)
			(3
				(if (!= global104 7)
					(= local5 (View new:))
					(local5
						view: 108
						setLoop: 6
						setCel: 0
						posn: 114 92
						ignoreActors:
						setPri: 15
						init:
					)
					(= seconds 3)
				)
			)
			(4
				(if (!= global104 7)
					(local5 dispose:)
					(global111 setScript: termChase)
					(= local1 1)
					(gEgo observeControl: 4096)
					(elevator
						view: 83
						setLoop: 2
						setCel: 4
						posn: 56 (elevTop y:)
						illegalBits: 0
						ignoreActors:
						setPri: 8
						setMotion: MoveTo 56 202 self
						init:
					)
					(cable1
						view: 83
						ignoreActors:
						posn: 56 83
						loop: 3
						cel: 255
						cycleSpeed: 5
						setCycle: End
					)
					(elevTop view: 777 stopUpd:)
					(elevBottom view: 777 stopUpd:)
				)
			)
			(5
				(= local1 0)
				(cable1 stopUpd:)
				(gEgo ignoreControl: 4096)
				(global111 observeControl: 4096)
			)
		)
	)
)

(instance termChase of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(cond
			((== local0 2)
				(cond
					((and (or (== global104 4) (== global104 3)) (!= state 1))
						(self changeState: 1)
					)
					((and (== global104 2) (!= state 7) (< state 8))
						(self changeState: 7)
					)
				)
			)
			((== local0 3)
				(cond
					((and (== global104 4) (!= state 2) (< state 8))
						(self changeState: 2)
					)
					((and (== global104 3) (< state 8) (!= state 7))
						(self changeState: 7)
					)
					((and (== global104 2) (< state 8) (!= state 5))
						(self changeState: 5)
					)
				)
			)
			((== local0 4)
				(cond
					((and (== global104 4) (< state 8) (!= state 7))
						(self changeState: 7)
					)
					((and (== global104 3) (< state 8) (!= state 4))
						(self changeState: 4)
					)
					((and (== global104 2) (!= state 4))
						(self changeState: 4)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 2)
				(global111 observeControl: 4096)
			)
			(1
				(global111 setMotion: MoveTo 286 156 self)
			)
			(2
				(global111
					setMotion: MoveTo 248 47 self
					setPri: 10
					ignoreControl: 16384 2048
					observeControl: 8192
				)
				(= local0 3)
			)
			(3
				(= local0 4)
				(global111
					setMotion: Chase gEgo 10 self
					observeControl: 4 16384
					ignoreControl: 8192
					setPri: -1
				)
				(= state 7)
			)
			(4
				(global111 ignoreControl: 2048 setMotion: MoveTo 252 51 self)
			)
			(5
				(= local0 3)
				(global111
					observeControl: 2048
					setMotion: MoveTo 290 156 self
					ignoreControl: 16384
					setPri: 10
					observeControl: 8192
				)
			)
			(6
				(= local0 2)
				(global111
					setMotion: Chase gEgo 10 self
					observeControl: 16384
					setPri: -1
					ignoreControl: 8192
				)
				(= state 7)
			)
			(7
				(global111 setMotion: Chase gEgo 10 self)
			)
			(8
				(HandsOff)
				(global111 posn: (gEgo x:) (gEgo y:))
				(gEgo
					view: 106
					setLoop: 4
					cel: 255
					ignoreHorizon:
					illegalBits: 0
					setCycle: End
					setPri: (gEgo priority:)
					setStep: 4 4
					setMotion:
						MoveTo
						(+ (gEgo x:) 11)
						(- (gEgo y:) 15)
						self
				)
			)
			(9
				(gEgo setLoop: 5 setCycle: Fwd)
				(global111
					view: 106
					setLoop: 6
					illegalBits: 0
					setPri: (gEgo priority:)
					setCycle: Fwd
					show:
				)
				(= seconds 2)
			)
			(10
				(global111
					view: 106
					setLoop: 7
					setPri: (gEgo priority:)
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(11
				(gEgo hide:)
				(= local7 (Sound new:))
				(local7 number: 97 loop: -1 priority: 99 play:)
				(global111 setLoop: 8 setCycle: Fwd)
				(= seconds 6)
			)
			(12
				(local7 stop:)
				(global111 setLoop: 8 setCel: 0)
				(EgoDead 901 0 14 16) ; "Thanks for playing Space Quest ]I[. As usual, you've been a real hoot."
			)
		)
	)
)

(instance doPulley of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (and (== local3 1) (== local0 4) (gCast contains: global111))
			(cond
				(
					(and
						(== (local2 heading:) 90)
						(< (Abs (- (global111 x:) (local2 x:))) 12)
						(or
							(and
								(== local2 pulley1)
								(> (global111 y:) 41)
								(< (global111 y:) 49)
							)
							(and
								(== local2 pulley2)
								(> (global111 y:) 60)
								(< (global111 y:) 72)
							)
						)
					)
					(if (or (< (global111 x:) 113) (> (global111 x:) 192))
						(= local3 3)
						(Print 421 44) ; "You missed!"
					else
						(self changeState: 5)
					)
				)
				(
					(and
						(== (local2 heading:) 270)
						(< (Abs (- (local2 x:) (global111 x:))) 12)
						(or
							(and
								(== local2 pulley1)
								(> (global111 y:) 41)
								(< (global111 y:) 49)
							)
							(and
								(== local2 pulley2)
								(> (global111 y:) 60)
								(< (global111 y:) 72)
							)
						)
					)
					(if (or (< (global111 x:) 113) (> (global111 x:) 192))
						(Print 421 44) ; "You missed!"
						(= local3 3)
					else
						(self changeState: 5)
					)
				)
			)
		)
		(if
			(and
				(== local3 1)
				(or
					(and (< (local2 x:) 39) (== (local2 heading:) 270))
					(and (> (local2 x:) 230) (== (local2 heading:) 90))
				)
			)
			(local2 cel: 1 setMotion: 0 stopUpd:)
			(= state 4)
			(RedrawCast)
			(Print 421 45) ; "Unfortunately, the pulley has come to the end of its track."
			(= local3 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					(
						(and
							(gCast contains: global111)
							(< (gEgo distanceTo: global111) 25)
						)
						(Print 421 46) ; "It's too late now."
						(gEgo setScript: 0)
					)
					(
						(and
							(== global104 4)
							(< (gEgo y:) 49)
							(< (Abs (- (gEgo x:) (pulley1 x:))) 10)
						)
						(= local2 pulley1)
						(self changeState: 1)
					)
					(
						(and
							(== global104 4)
							(> (gEgo y:) 61)
							(< (Abs (- (gEgo x:) (pulley2 x:))) 10)
						)
						(= local2 pulley2)
						(self changeState: 1)
					)
					(else
						(NotClose) ; "It's not quite within reach."
						(gEgo setScript: 0)
					)
				)
			)
			(1
				(Print 421 47 #at -1 (- (gEgo y:) 20)) ; "Reaching up, you give the rope pulley a mighty shove."
				(switch (gEgo loop:)
					(0
						(local2
							startUpd:
							cel: 0
							xStep: 8
							setMotion:
								MoveTo
								(+ (local2 x:) 50)
								(local2 y:)
								self
						)
					)
					(1
						(local2
							startUpd:
							cel: 2
							xStep: 6
							setMotion:
								MoveTo
								(- (local2 x:) 50)
								(local2 y:)
								self
						)
					)
					(else
						(if (gCast contains: global111)
							(if (< (gEgo x:) (global111 x:))
								(local2
									startUpd:
									cel: 0
									xStep: 8
									setMotion:
										MoveTo
										(+ (local2 x:) 50)
										(local2 y:)
										self
								)
							else
								(local2
									startUpd:
									cel: 2
									xStep: 8
									setMotion:
										MoveTo
										(- (local2 x:) 50)
										(local2 y:)
										self
								)
							)
						else
							(local2
								startUpd:
								cel: 0
								xStep: 8
								setMotion:
									MoveTo
									(+ (local2 x:) 50)
									(local2 y:)
									self
							)
						)
					)
				)
				(= local3 1)
			)
			(2
				(if (== (local2 heading:) 90)
					(local2
						cel: 1
						setMotion: MoveTo (+ (local2 x:) 50) (local2 y:) self
					)
				else
					(local2
						cel: 1
						setMotion: MoveTo (- (local2 x:) 50) (local2 y:) self
					)
				)
			)
			(3
				(if (== (local2 heading:) 90)
					(local2
						cel: 2
						setMotion: MoveTo (+ (local2 x:) 50) (local2 y:) self
					)
				else
					(local2
						cel: 0
						setMotion: MoveTo (- (local2 x:) 50) (local2 y:) self
					)
				)
			)
			(4
				(= local3 0)
				(local2 cel: 1 setMotion: 0 stopUpd:)
			)
			(5
				(= local3 2)
				(if (== (local2 heading:) 90)
					(local2
						cel: 1
						setMotion: MoveTo (- (local2 x:) 15) (local2 y:)
					)
				else
					(local2
						cel: 1
						setMotion: MoveTo (+ (local2 x:) 15) (local2 y:)
					)
				)
				(= local0 6)
				(HandsOff)
				(= local6 (View new:))
				(local6
					view: 120
					loop: 1
					cel: 3
					posn: (global111 x:) (- (global111 y:) 30)
					setPri: 15
					init:
				)
				(global111
					view: 120
					setLoop: (- 3 (& (global111 loop:) $0001))
					cel: 255
					illegalBits: 0
					setCycle: End
					setStep: 6 4
					setMotion: MoveTo 160 55 self
				)
				(= seconds 2)
			)
			(6
				(local6 dispose:)
			)
			(7
				(deathSound number: 91 priority: 20 play:)
				(global111
					setLoop: 4
					setCycle: Fwd
					setPri: -1
					setMotion: MoveTo 160 127 self
				)
			)
			(8
				(HandsOn)
				(= local0 5)
				(global111 ignoreActors: 0 setCel: 6 setPri: 0 stopUpd:)
				(= gView (View new:))
				(gView
					view: 120
					loop: 5
					cel: 0
					posn: 157 124
					setPri: 1
					init:
				)
				(gGame changeScore: 35)
				(PutItem 16 421) ; Invisibility_Belt
				(gEgo setScript: 0)
				(gCurRoom setScript: bringOnFester)
				(= global117 421)
				(= global110 3)
			)
		)
	)
)

(instance smash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(deathSound number: 92 priority: 21 play:)
				(gEgo
					view: 120
					setLoop: 6
					illegalBits: 0
					ignoreActors:
					posn: 156 63
					setPri: 7
					setCycle: Fwd
				)
				(= seconds 7)
				(if
					(and
						(gCast contains: global111)
						(< local0 5)
						(gCast contains: global111)
						(== (global111 script:) termChase)
					)
					(gCurRoom setScript: 0)
					(global111 setMotion: 0)
				)
			)
			(1
				(EgoDead 901 0 3 99) ; "Thanks for playing Space Quest ]I[. As usual, you've been a real hoot."
			)
		)
	)
)

(instance bringOnFester of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (and (== local1 2) (& (gEgo onControl: 0) $1000))
			(self changeState: 10)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(gEgo observeControl: 4096)
				(= local1 1)
				(elevator setCel: 5 setPri: 9 setMotion: MoveTo 56 83 self)
				(cable1 cel: 9 setCycle: Beg)
			)
			(2
				(elevator setPri: 9 setMotion: MoveTo 56 85 self)
			)
			(3
				(HandsOff)
				(pulley1 startUpd:)
				(pulley2 setPri: 14 startUpd:)
				(gear setCycle: Fwd startUpd:)
				(gLongSong loop: -1 play:)
				(== local8 -200)
				(RedrawCast)
				(Print 421 48 #at 66 53 #dispose #title {Fester}) ; "Hey! What's going on here! Didn't you read the sign saying we're closed for repairs?"
				(= seconds 8)
			)
			(4
				(cls)
				(RedrawCast)
				(Print 421 49 #at 66 29 #dispose #title {Fester}) ; "Oh! I see you've gotten rid of that grease swilling android. Never did like that terminator series. Good riddance to bad circuits!"
				(= seconds 12)
			)
			(5
				(cls)
				(Print 421 50 #at 66 65 #dispose #title {Fester}) ; "Well, you might as well ride down with me."
				(gEgo ignoreControl: 4096)
				(= local1 2)
				(= seconds 4)
			)
			(6
				(cls)
				(HandsOn)
				(gEgo ignoreControl: 4096)
				(= seconds 15)
			)
			(7
				(cls)
				(Print 421 51 #at 66 64 #time 5 #title {Fester}) ; "Come on, come on! I don't have all day."
				(-- state)
				(= seconds 20)
			)
			(10
				(HandsOff)
				(= seconds 0)
				(pulley1 stopUpd:)
				(pulley2 stopUpd:)
				(gEgo view: 777 stopUpd:)
				(elevTop view: 777 stopUpd:)
				(elevBottom view: 777 stopUpd:)
				(elevator
					setLoop: 2
					setCel: 6
					setMotion: MoveTo (elevator x:) 220 self
				)
				(cable1 setCycle: End)
			)
			(11
				(gCurRoom newRoom: 42)
			)
		)
	)
)

(instance fall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bringOnFester seconds: 0)
				(gCurRoom setScript: 0)
				(elevator
					view: 94
					setLoop: 0
					cel: 255
					yStep: 9
					ignoreActors:
					illegalBits: 0
					posn: 56 (gEgo y:)
					cycleSpeed: 3
					setCycle: End
					init:
				)
				(deathSound number: 45 priority: 12 loop: 1 play:)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setPri: 8
					yStep: 15
					posn: 64 127
					setCycle: 0
					setMotion: MoveTo 64 300 self
				)
				(= global104 7)
				(if (and (gCast contains: global111) (< local0 5))
					(global111 setScript: 0 setMotion: 0)
				)
			)
			(1
				(elevator hide:)
				(= seconds 6)
			)
			(2
				(EgoDead 901 0 0 1) ; "It wouldn't be so bad, except for the sudden stop at the end.__Next time, don't get so close to the edge."
			)
		)
	)
)

(instance lowerEgoElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global104 1)
				(gEgo setMotion: MoveTo 56 129 self)
			)
			(1
				(gEgo view: 777 stopUpd:)
				(elevTop view: 777 stopUpd:)
				(elevBottom view: 777 stopUpd:)
				(elevator
					view: 83
					setLoop: 2
					setCel: 2
					setPri: 8
					illegalBits: 0
					ignoreActors:
					posn: (elevBottom x:) (elevBottom y:)
					setMotion: MoveTo (elevBottom x:) 220 self
					init:
				)
				(cable1 setCycle: End)
			)
			(2
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance gearActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (not global124)
			(cond
				((== local4 0)
					(if
						(or
							(== global104 7)
							(== local3 1)
							(== local0 6)
							(>= local8 200)
						)
						(= local8 0)
						(gear setCycle: Fwd startUpd:)
						(gLongSong loop: -1 play:)
						(= local4 1)
					else
						(++ local8)
					)
				)
				(
					(and
						(!= global104 7)
						(or
							(>= local8 40)
							(and
								(gCast contains: elevator)
								(< (elevator y:) 189)
							)
						)
					)
					(= local4 0)
					(gear setCycle: 0 stopUpd:)
					(gLongSong stop:)
					(= local8 0)
				)
				(else
					(++ local8)
				)
			)
		)
	)
)

