;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use Interface)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	rm290 0
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
	local17
	local18
)

(procedure (localproc_0)
	(= local2 (Random 70 248))
)

(procedure (localproc_1)
	(if (gEgo has: 8) ; Buckazoids
		(if (not (-- global154))
			(gEgo put: 8 -1) ; Buckazoids
		)
		(gCurRoom drawPic: 292)
		(Display 290 13 dsCOORD 52 180 dsWIDTH 91 dsCOLOR 0 dsBACKGROUND 0 dsFONT 600) ; "Insert Buckazoid!"
		(Display 290 17 dsCOORD 50 180 dsWIDTH 55 dsCOLOR 15 dsBACKGROUND 0 dsFONT 600) ; "Feed:"
		(Display 290 12 dsCOORD 148 180 dsFONT 600 dsWIDTH 90 dsCOLOR 0) ; "PRESS F6 TO EXIT"
		(guysLeft init:)
		(localproc_0)
		(= local3 22)
		(= local0 local2)
		(= local1 local3)
		(= local4 1)
		(= local5 0)
		(= local7 0)
		(= local8 0)
		(= local6 100)
		(= local10 2)
		(= local11 3)
		(= local12 0)
		(= local13 0)
		(++ global589)
		(= local16 1)
		(= local15 0)
		(Chicken init:)
		(Csong play: loop: -1)
		(HandsOff)
		(= local17 (GetMenu 1282 113))
		(TheMenuBar hide: state: 0)
		(SL enable: state: 1)
		(gCurRoom setScript: 0)
	else
		(Print 290 18) ; "You don't even have a buck."
	)
)

(instance rm290 of Rm
	(properties
		style 7
	)

	(method (init)
		(Load rsVIEW 290)
		(Load rsVIEW 291)
		(Load rsPIC 290)
		(Load rsPIC 291)
		(Load rsPIC 292)
		(Load rsSOUND 26)
		(Load rsSOUND 33)
		(super init:)
		(= global193 1)
		(self setScript: intro)
	)

	(method (doit &tmp [temp0 30])
		(super doit:)
		(if (== script 0)
			(Display
				(Format @temp0 290 0 local6) ; "%d"
				dsCOORD
				80
				180
				dsWIDTH
				15
				dsCOLOR
				15
				dsBACKGROUND
				0
				dsFONT
				600
			)
			(if (not local6)
				(HandsOff)
				(= local15 1)
				(= local5 0)
				(switch local10
					(2
						(Chicken loop: 3)
					)
					(0
						(Chicken loop: 4)
					)
					(1
						(Chicken loop: 5)
					)
				)
			)
			(if (== (Chicken onControl: 1) 16384)
				(= local15 1)
				(self setScript: blowUp)
			)
			(if (== (Chicken onControl: 1) 2048)
				(self setScript: tooHigh)
			)
			(if (and (== (Chicken onControl: 1) 4096) (== local13 0))
				(if (< (Abs local4) 6)
					(self setScript: landedOK)
				else
					(Chicken loop: 8 cel: 0)
					(= local5 0)
					(= local13 1)
					(-= local4 (* local4 2))
					(if (== local9 0)
						(= local9 4)
						(= local10 0)
						(= local7 4)
						(Chicken setCycle: Fwd)
					else
						(= local9 5)
						(= local10 1)
						(= local7 -4)
						(Chicken setCycle: Rev)
					)
					(= local8 -10)
				)
			)
			(cond
				((== local5 1)
					(if (< (-- local4) -10)
						(= local4 -10)
					)
					(-- local6)
				)
				((> (++ local4) 10)
					(= local4 10)
				)
			)
			(if (and (!= (Chicken loop:) 2) (== local5 1))
				(= local8 1)
				(= local9 (Chicken loop:))
			)
			(if (!= local8 0)
				(if
					(or
						(== local5 0)
						(and (== local5 1) (== (Chicken loop:) 2))
					)
					(++ local8)
				)
				(cond
					((== local8 12)
						(= local8 0)
						(= local7 0)
					)
					((!= (Abs local7) 4)
						(if (== local9 1)
							(= local7 -2)
						else
							(= local7 2)
						)
					)
				)
			)
			(if (< local0 52)
				(= local0 265)
			)
			(if (> local0 265)
				(= local0 52)
			)
			(Chicken x: (+= local0 local7) y: (+= local1 local4))
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_ADD
						(if (> gSpeed 1)
							(gGame setSpeed: (-- gSpeed))
						)
					)
					(KEY_SUBTRACT
						(if (< gSpeed 16)
							(gGame setSpeed: (++ gSpeed))
						)
					)
					($003d ; =
						(gGame setSpeed: 5)
					)
					(KEY_F2
						(if local17
							(= local17 0)
							(DoSound sndSET_SOUND 0)
							(SetMenu 1282 113 0 110 {Turn on})
						else
							(= local17 1)
							(DoSound sndSET_SOUND 1)
							(SetMenu 1282 113 1 110 {Turn off})
						)
					)
					(KEY_F6
						(event claimed: 1)
						(= global193 0)
						(= global159 0)
						(gCurRoom newRoom: 29)
					)
				)
			)
			(evSAID
				(cond
					((Said 'play[/game,astro,astro]')
						(Print 290 1) ; "It costs one buckazoid."
					)
					((Said 'aid[<get]')
						(Print 290 2) ; "The on-screen instructions explain all aspects of Astro Chicken."
					)
					((Said 'read,look,use/instruction')
						(Print 290 3) ; "Just be patient, the instructions will cycle through until you insert a buckazoid."
					)
					((Said 'insert,use,drop[<in]/bill')
						(localproc_1)
					)
					((or (Said 'disembark,quit[/game,device]') (Said '/bye'))
						(= global193 0)
						(= global159 0)
						(gCurRoom newRoom: 29)
					)
					((Said 'hit,tilt/game,device')
						(Print 290 4) ; "The sophisticated electronics resist your feeble tamperings."
					)
					((Said 'look[/area,around,game,device]')
						(Print 290 5) ; "Don't stand there gawkin', let's play some Astro Chicken!"
					)
					((Said 'look/letter')
						(if local18
							(Print 290 6) ; "It appears to be in code."
							(if (gEgo has: 7) ; Monolith_Decoder_Ring
								(Print 290 7) ; "If you only had a way to decode it..."
							else
								(Print 290 8) ; "But you don't have any way to decode it."
								(gCurRoom setScript: intro)
							)
						else
							(Print 290 9) ; "There's no message here."
						)
					)
					((or (Said 'use/decoder,relic') (Said 'decode/letter'))
						(= global159 1)
						(RedrawCast)
						(if (gEgo has: 7) ; Monolith_Decoder_Ring
							(if (and (< global590 120) (not global170) local18)
								(gGame changeScore: 20)
								(+= global590 20)
								(= global170 1)
							)
							(= local14
								(Print ; "the secret code goes something like this: a{{ b{{ c{{ d{{ e{{ f{{ g{ h{ i{{ j{{ k{{ l{{ m A B C D E F G H I J K L M n{ o{ p{ q{ r{{ s{{ t{ u{ v{ w{ x{ y{ z N O P Q R S T U V W X Y Z"
									290
									10
									#font
									603
									#icon
									242
									0
									5
									#width
									240
									#at
									-1
									143
								)
							)
							(= local18 0)
							(= global193 0)
							(= global159 0)
							(self newRoom: 29)
						else
							(Print 290 11) ; "You don't have any way of doing that."
							(gCurRoom setScript: intro)
						)
					)
				)
			)
			($0040 ; direction
				(= local13 0)
				(switch (event message:)
					(JOY_UP
						(if (== local15 0)
							(Chicken setCycle: Fwd)
							(= local7 0)
							(if (== local5 1)
								(= local5 0)
								(switch local10
									(2
										(Chicken loop: 3)
									)
									(0
										(Chicken loop: 4)
									)
									(1
										(Chicken loop: 5)
									)
								)
							else
								(= local5 1)
								(switch local10
									(2
										(Chicken loop: 2)
									)
									(0
										(Chicken loop: 0)
									)
									(1
										(Chicken loop: 1)
									)
								)
							)
						)
					)
					(JOY_DOWN
						(if (== local15 0)
							(= local10 2)
							(Chicken loop: (if (== local5 1) 2 else 3) cel: 0)
						)
					)
					(JOY_RIGHT
						(if (== local15 0)
							(= local10 0)
							(Chicken loop: (if (== local5 1) 0 else 4) cel: 0)
						)
					)
					(JOY_LEFT
						(if (== local15 0)
							(= local10 1)
							(Chicken loop: (if (== local5 1) 1 else 5) cel: 0)
						)
					)
					(JOY_UPLEFT
						(event claimed: 1)
						(return)
					)
					(JOY_UPRIGHT
						(event claimed: 1)
						(return)
					)
					(JOY_DOWNLEFT
						(event claimed: 1)
						(return)
					)
					(JOY_DOWNRIGHT
						(event claimed: 1)
						(return)
					)
					(JOY_NULL
						(if (== local15 0)
							(= local10 2)
							(Chicken loop: (if (== local5 1) 2 else 3) cel: 0)
						)
					)
				)
			)
			(evJOYDOWN
				(if (== local15 0)
					(Chicken setCycle: Fwd)
					(= local7 0)
					(= local5 1)
					(switch local10
						(2
							(Chicken loop: 2)
						)
						(0
							(Chicken loop: 0)
						)
						(1
							(Chicken loop: 1)
						)
					)
				)
			)
			(evJOYUP
				(if (== local15 0)
					(Chicken setCycle: Fwd)
					(= local7 0)
					(= local5 0)
					(switch local10
						(2
							(Chicken loop: 3)
						)
						(0
							(Chicken loop: 4)
						)
						(1
							(Chicken loop: 5)
						)
					)
				)
			)
			(evMOUSEBUTTON
				(if (and (<= 146 (event x:) 228) (<= 178 (event y:) 187))
					(event claimed: 1)
					(= global193 0)
					(= global159 0)
					(gCurRoom newRoom: 29)
				)
				(if
					(and
						(<= 39 (event x:) 142)
						(<= 175 (event y:) 189)
						(not local16)
					)
					(event claimed: 1)
					(localproc_1)
				)
			)
		)
	)
)

(instance intro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(= global159 0)
				(guysLeft dispose:)
				(client drawPic: 291)
				(Display 290 12 dsCOORD 148 180 dsFONT 600 dsWIDTH 90 dsCOLOR 0) ; "PRESS F6 TO EXIT"
				(Display 290 13 dsCOORD 52 180 dsWIDTH 91 dsCOLOR 15 dsBACKGROUND 0 dsFONT 600) ; "Insert Buckazoid!"
				(RedrawCast)
				(= local16 0)
				(= seconds 5)
			)
			(1
				(client drawPic: 290)
				(Display 290 12 dsCOORD 148 180 dsFONT 600 dsWIDTH 90 dsCOLOR 0) ; "PRESS F6 TO EXIT"
				(Display 290 13 dsCOORD 52 180 dsWIDTH 91 dsCOLOR 15 dsBACKGROUND 0 dsFONT 600) ; "Insert Buckazoid!"
				(Display 290 14 dsCOORD 60 60 dsWIDTH 200 dsCOLOR 15 dsBACKGROUND 0 dsFONT 600) ; "ASTRO CHICKEN MUST LAND ON THE   ASTRO CHICKEN LANDING PAD.   HE'S DEPENDING ON YOU TO BRING     HIM TO SAFETY!"
				(= seconds 6)
			)
			(2
				(Display 290 12 dsCOORD 148 180 dsFONT 600 dsWIDTH 90 dsCOLOR 0) ; "PRESS F6 TO EXIT"
				(Display 290 13 dsCOORD 52 180 dsWIDTH 91 dsCOLOR 15 dsBACKGROUND 0 dsFONT 600) ; "Insert Buckazoid!"
				(Display 290 14 dsCOORD 60 60 dsWIDTH 200 dsCOLOR 0 dsBACKGROUND 0 dsFONT 600) ; "ASTRO CHICKEN MUST LAND ON THE   ASTRO CHICKEN LANDING PAD.   HE'S DEPENDING ON YOU TO BRING     HIM TO SAFETY!"
				(Display 290 15 dsCOORD 60 30 dsWIDTH 200 dsCOLOR 15 dsBACKGROUND 0 dsFONT 600) ; "Controls: Left arrow: move left Down arrow: stop left/right movement Right arrow: move right Up arrow: toggle flapping Feed: don't use up all your feed! Hit the landing pad too fast and you'll bounce back up. Landing outside the landing pad is fatal. If you fly too high you'll bounce off the atmosphere and plummet back to the surface."
				(= seconds 15)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance landedOK of Script
	(properties)

	(method (changeState newState &tmp [temp0 5])
		(switch (= state newState)
			(0
				(= local15 1)
				(Chicken loop: 6 cel: 0 setCycle: End self)
			)
			(1
				(Bacock init: setCycle: End self)
			)
			(2
				(= seconds 2)
			)
			(3
				(Bacock dispose:)
				(RedrawCast)
				(++ local12)
				(if (< global590 50)
					(gGame changeScore: 5)
					(+= global590 5)
				)
				(if (or (== local12 3) (== local12 6) (== local12 9))
					(++ local11)
				)
				(if (== local12 10)
					(client setScript: youWon)
					(= local15 1)
				else
					(= cycles 2)
				)
			)
			(4
				(localproc_0)
				(= local0 local2)
				(= local1 local3)
				(= local4 1)
				(= local5 0)
				(= local7 0)
				(= local8 0)
				(= local10 2)
				(= local6 100)
				(Chicken x: local2 y: local3 loop: 3 setCycle: Fwd)
				(= local15 0)
				(client setScript: 0)
			)
		)
	)
)

(instance youWon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Csong stop:)
				(Chicken dispose:)
				(if (< global590 100)
					(gGame changeScore: 50)
					(+= global590 50)
				)
				(client drawPic: 290)
				(Display 290 12 dsCOORD 148 180 dsFONT 600 dsWIDTH 90 dsCOLOR 0) ; "PRESS F6 TO EXIT"
				(= local18 1)
				(= global159 1)
				(TheMenuBar draw: state: 1)
				(User canInput: 1)
				(= local14
					(Display 290 16 dsCOORD 60 30 dsWIDTH 200 dsCOLOR 15 dsBACKGROUND 0 dsFONT 603) ; "HELP US! WE ARE BEING HELD CAPTIVE BY SCUMSOFT ON THE SMALL MOON OF PESTULON. AN INPENETRABLE FORCE FIELD SURROUNDS THE MOON. IT MUST FIRST BE DEACTIVATED. IT'S ORIGIN IS UNKNOWN TO US. SCUMSOFT SECURITY IS ARMED WITH JELLO PISTOLS. WE'RE COUNTING ON YOU WHOEVER YOU ARE.    TWO GUYS IN TROUBLE"
				)
			)
		)
	)
)

(instance blowUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(boom play:)
				(explosion
					loop: 0
					cel: 0
					x: (Chicken x:)
					y: (+ (Chicken y:) 10)
					init:
					setCycle: End self
				)
				(Chicken hide:)
			)
			(1
				(explosion loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(rm290 setScript: death)
				(explosion dispose:)
			)
		)
	)
)

(instance tooHigh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 1)
				(= local5 0)
				(= local7 0)
				(= local8 0)
				(= local10 2)
				(= local15 0)
				(= local13 0)
				(Chicken loop: 3)
				(client setScript: 0)
			)
		)
	)
)

(instance death of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (-- local11) 0)
					(client setScript: byeBye)
				else
					(= cycles 2)
				)
			)
			(1
				(localproc_0)
				(Chicken x: local2 y: local3 show:)
				(= local0 local2)
				(= local1 local3)
				(= local4 1)
				(= local5 0)
				(= local7 0)
				(= local8 0)
				(= local10 2)
				(= local6 100)
				(= local15 0)
				(= local13 0)
				(Chicken loop: 3)
				(client setScript: 0)
			)
		)
	)
)

(instance byeBye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Csong stop:)
				(gameOver init: setCycle: Fwd)
				(TheMenuBar draw: state: 1)
				(SL enable: state: 1)
				(= seconds 4)
			)
			(1
				(gameOver dispose:)
				(if (== global589 10)
					(gCurRoom setScript: youWon)
				else
					(Chicken dispose:)
					(gCurRoom setScript: intro)
				)
			)
		)
	)
)

(instance Chicken of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 290
			ignoreActors:
			setLoop: 3
			setCel: 0
			setPri: 13
			x: local0
			y: local1
			setStep: 1
		)
	)
)

(instance guysLeft of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 290 setLoop: 7 setCel: 0 setPri: 15 x: 100 y: 189 stopUpd:)
	)

	(method (doit)
		(super doit:)
		(self setCel: (- local11 1))
	)
)

(instance Bacock of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 291
			setPri: 14
			setLoop: 2
			posn: (- (Chicken x:) 2) (- (Chicken y:) 21)
		)
	)
)

(instance gameOver of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 291 setLoop: 3 setPri: 14 posn: 155 91)
	)
)

(instance explosion of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 291 setPri: 14 setLoop: 0 setCel: 0)
	)
)

(instance Csong of Sound
	(properties
		number 26
		loop -1
	)
)

(instance boom of Sound
	(properties
		number 33
		priority 1
	)
)

