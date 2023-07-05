;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use Blk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	astro 0
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
	[local9 6] = [0 5 4 3 2 1]
	[local15 6] = [0 9 8 7 6 5]
	local21 = 50
)

(instance theSound of Sound
	(properties)
)

(instance winged of Sound
	(properties
		number 56
	)
)

(instance eggSquirt of Sound
	(properties
		number 122
	)
)

(instance eggFall of Sound
	(properties
		number 131
	)
)

(instance eggSplatting of Sound
	(properties
		number 147
	)
)

(instance gunshot of Sound
	(properties
		number 144
	)
)

(instance cornPicker of Sound
	(properties
		number 146
	)
)

(instance astro of SQRoom
	(properties
		picture 290
	)

	(method (init)
		(Load rsVIEW 290)
		(super init:)
		(astroChicken
			init:
			setCycle: Fwd
			observeBlocks:
			livesLeft: 3
			showEggs:
			showPts:
		)
		((astroChicken blocks:) add: theCage)
		(gIconBar disable:)
	)

	(method (dispose)
		(gIconBar enable:)
		(DisposeScript 949)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(Palette palANIMATE 48 55 -1)
		(if (not (-- local21))
			(= local21 50)
			(if (not (gCast contains: henHouseRight))
				(if (not (gCast contains: rock))
					(rock init:)
				)
				(if (not (gCast contains: grass))
					(grass init:)
				)
			)
		)
		(cond
			(local3
				(if (and (not (-- local3)) local4)
					((cornStalk new:) init:)
					(= local3 3)
					(-- local4)
				)
			)
			(
				(and
					(>= local8 250)
					(not (gCast contains: crazedFarmer))
					(not (gCast contains: windMill))
					(not (gCast contains: weasel))
					(not (gCast contains: rabidDog))
					(not (gCast contains: astroChicken2))
				)
				(henHouseLeft init:)
				(henHouseRight init:)
				(astroChicken2
					loop: (astroChicken loop:)
					x: (astroChicken x:)
					y: (astroChicken y:)
					init:
					setCycle: Fwd
				)
				(astroChicken hide: dispose:)
				(gCurRoom setScript: doHenHouse)
			)
			(
				(or
					(gCast contains: hill)
					(gCast contains: crazedFarmer)
					(gCast contains: windMill)
					(gCast contains: weasel)
					(gCast contains: chickenWire)
					(gCast contains: henHouseRight)
				))
			((or (gSounds contains: winged) (gSounds contains: 55)))
			((<= (= temp0 (Random 1 100)) 15)
				(hill init:)
				(switch (Random 0 2)
					(0
						(if (not (gCast contains: rabidDog))
							(rabidDog init:)
						)
					)
					(1
						(if (not (gCast contains: crazedFarmer))
							(crazedFarmer init:)
						)
					)
				)
			)
			((<= temp0 30)
				(crazedFarmer init:)
			)
			((<= temp0 40)
				(windMill init:)
			)
			((<= temp0 65)
				(if
					(and
						(< (astroChicken eggsLeft:) 5)
						(not (gCast contains: cornStalk))
					)
					(= local3 3)
					(= local4 (Random 4 9))
				)
			)
			((<= temp0 80)
				(weasel init:)
			)
			(
				(and
					(<= temp0 85)
					(not (astroChicken loop:))
					(not (gCast contains: chickenWire))
				)
				(chickenWire init:)
			)
			((not (gCast contains: rabidDog))
				(rabidDog init:)
			)
		)
	)
)

(class astroChicken of Actor
	(properties
		view 290
		signal 2048
		livesLeft 3
		eggsLeft 10
		wireLeft 0
	)

	(method (init &tmp temp0)
		(gLongSong number: 54 loop: -1 vol: 127 playBed:)
		(super init:)
		(self
			show:
			x: 160
			y: 40
			eggsLeft: 10
			loop: 0
			wireLeft: 0
			showEggs:
			showPts:
		)
		(astroIndicator init: addToPic:)
		(gFtrInitializer addToFront: self)
		(gSq4KeyDownHandler addToFront: self)
		(= temp0 (proc0_12 {Eggs:} 67 150 178 28 global136))
		(= temp0 (proc0_12 {Score:} 67 240 178 28 global136))
	)

	(method (dispose)
		(gFtrInitializer delete: self)
		(gSq4KeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(switch (event type:)
			($0040 ; direction
				(event claimed: 1)
				(switch (event message:)
					(JOY_LEFT
						(astroChicken setMotion: MoveTo 0 (astroChicken y:))
					)
					(JOY_RIGHT
						(astroChicken setMotion: MoveTo 320 (astroChicken y:))
					)
					(JOY_UP
						(astroChicken setMotion: MoveTo (astroChicken x:) 0)
					)
					(JOY_DOWN
						(astroChicken setMotion: MoveTo (astroChicken x:) 190)
					)
				)
			)
			(evMOUSEBUTTON
				(event claimed: 1)
				(if (== (event modifiers:) emSHIFT)
					(if (and eggsLeft (not (gCast contains: egg)))
						(eggSquirt play:)
						(egg init:)
						(-- eggsLeft)
						(self showEggs:)
					)
				else
					(= temp0 (Min 213 (Max 87 (event x:))))
					(astroChicken setMotion: MoveTo temp0 (event y:))
				)
			)
			(evKEYBOARD
				(event claimed: 1)
				(if
					(and
						(== (event message:) KEY_RETURN)
						eggsLeft
						(not (gCast contains: egg))
					)
					(eggSquirt play:)
					(egg init:)
					(-- eggsLeft)
					(self showEggs:)
				)
			)
		)
	)

	(method (die)
		(if (not (-- livesLeft))
			(Print 290 0) ; "Game Over"
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(gCurRoom newRoom: 376)
		else
			(winged dispose:)
			(gCast eachElementDo: #dispose)
			(gCurRoom drawPic: (gCurRoom picture:) style: 15)
			(self init:)
			(astroIndicator cel: (- (astroIndicator cel:) 1) init:)
		)
	)

	(method (showEggs &tmp [temp0 5])
		(proc0_12 local0)
		(= local0
			(proc0_12
				(Format @temp0 {%d} eggsLeft)
				67
				180
				178
				28
				global136
				70
				25
			)
		)
	)

	(method (showPts &tmp [temp0 5])
		(proc0_12 local1)
		(= local1
			(proc0_12 (Format @temp0 {%d} local8) 67 275 178 28 global136 70 25)
		)
	)

	(method (getEgg &tmp temp0)
		(++ eggsLeft)
		(= temp0 (Max 0 (- eggsLeft 8)))
		(self showEggs:)
	)

	(method (incScore param1 &tmp [temp0 41] temp41)
		(if (> param1 1)
			(+= local8 param1)
		else
			(= temp41 (/ y 20))
			(if param1
				(+= local8 [local9 temp41])
			else
				(+= local8 [local15 temp41])
			)
		)
		(self showPts:)
	)
)

(class ScrollActor of Actor
	(properties
		view 290
		priority 12
		signal 2064
		scrollSpeed 9
		deathLoop 0
		deathMusic 0
	)

	(method (init)
		(= nsRight (= nsBottom (= nsLeft (= nsTop 0))))
		(super init:)
		(= x 350)
	)

	(method (doit)
		(super doit:)
		(cond
			((< (-= x scrollSpeed) -50)
				(self dispose:)
			)
			((and (astroChicken isNotHidden:) (self onMe: astroChicken))
				(self doChicken:)
			)
			((and (gCast contains: egg) (self onMe: egg))
				(self doEgg:)
			)
		)
	)

	(method (doChicken)
		(if deathLoop
			(gLongSong stop:)
			(eggSplatting stop:)
			(theSound number: deathMusic loop: 1 play: self)
			(astroChicken hide:)
			(self setLoop: deathLoop setCel: 0 cycleSpeed: 2 setCycle: End)
		)
	)

	(method (doEgg))

	(method (cue)
		(astroChicken die:)
	)
)

(instance hill of ScrollActor
	(properties
		y 143
		loop 11
		cel 4
	)

	(method (init)
		(self setCel: (Random 4 5))
		(super init:)
	)
)

(instance grass of ScrollActor
	(properties
		loop 11
		cel 6
	)

	(method (init)
		(super init:)
		(= scrollSpeed 11)
		(+= x (Random 0 150))
		(= y 155)
		(self setPri: 14)
	)
)

(instance rock of ScrollActor
	(properties
		y 143
		loop 11
		cel 7
		priority 13
	)

	(method (init)
		(super init:)
		(= scrollSpeed 11)
		(+= x (Random 0 150))
		(= y 155)
		(self setPri: 14)
	)
)

(instance weasel of ScrollActor
	(properties
		illegalBits 0
		deathLoop 7
		deathMusic 55
	)

	(method (init)
		(= scrollSpeed 13)
		(= loop 4)
		(= y (astroChicken y:))
		(super init:)
		(self setCycle: Fwd)
	)

	(method (onMe param1 &tmp temp0)
		(= temp0 0)
		(cond
			(
				(not
					(and
						(<= nsLeft (param1 x:) (- nsRight 15))
						(<= (- nsTop 5) (param1 y:) (+ nsBottom 10))
					)
				))
			((== scrollSpeed 9))
			((astroChicken loop:)
				(astroChicken
					wireLeft: (- (astroChicken wireLeft:) 1)
					incScore: 5
				)
				(weasel scrollSpeed: 9)
				(if (not (astroChicken wireLeft:))
					(astroChicken setLoop: 0)
				)
			)
			(else
				(= temp0 1)
			)
		)
		(return temp0)
	)
)

(instance crazedFarmer of ScrollActor
	(properties
		loop 5
	)

	(method (init)
		(= loop 5)
		(if (gCast contains: hill)
			(= y 130)
		else
			(= y 143)
		)
		(super init:)
		(= local2 10)
	)

	(method (doEgg)
		(astroChicken incScore: 0)
		(eggFall stop:)
		(eggSplatting play:)
		(egg dispose:)
		(self setLoop: 8 setCel: 0 setCycle: End)
	)

	(method (doit)
		(super doit:)
		(cond
			((== loop 8))
			((and (not cycler) (astroChicken isNotHidden:) (not (-- local2)))
				(self setCycle: End self)
			)
		)
		(if
			(and
				(== loop 5)
				(<= x (astroChicken x:))
				(astroChicken isNotHidden:)
			)
			(self setLoop: 6)
		)
	)

	(method (cue)
		(gunshot play:)
		((buckShot new:) init:)
		(self setCycle: Beg)
		(= local2 (Random 5 10))
	)

	(method (onMe param1)
		(return
			(and
				(<= nsLeft (param1 x:) nsRight)
				(<= nsTop (param1 y:) (- nsBottom 15))
			)
		)
	)
)

(instance windMill of ScrollActor
	(properties
		loop 11
	)

	(method (init)
		(super init:)
		(= y 105)
		(self setPri: 13)
		(windMillBlade init:)
	)
)

(instance windMillBlade of ScrollActor
	(properties
		deathLoop 13
		deathMusic 55
	)

	(method (init)
		(= loop 12)
		(super init:)
		(= y 105)
		(self setPri: 14 setCycle: Fwd)
	)
)

(instance cornStalk of ScrollActor
	(properties
		y 120
		loop 11
		cel 1
	)

	(method (init)
		(super init:)
		((cornTop new:) init:)
	)
)

(instance cornTop of ScrollActor
	(properties
		y 120
		loop 11
		cel 2
	)

	(method (doChicken)
		(cornPicker play:)
		(astroChicken getEgg:)
		(self hide:)
	)

	(method (onMe param1)
		(return
			(and
				(<= (- nsLeft 1) (param1 x:) (+ nsRight 2))
				(<= (- nsTop 10) (param1 y:) (+ nsBottom 15))
			)
		)
	)
)

(instance rabidDog of ScrollActor
	(properties
		deathLoop 10
		deathMusic 140
	)

	(method (init)
		(= loop 15)
		(= cycleSpeed (= cel 0))
		(if (gCast contains: hill)
			(= y 130)
		else
			(= y 143)
		)
		(super init:)
	)

	(method (doChicken)
		(if (and (== loop 15) (not cycler))
			(if (< (- y (astroChicken y:)) 50)
				(super doChicken:)
			else
				(self setCycle: End)
			)
		)
	)

	(method (doEgg)
		(astroChicken incScore: 1)
		(eggFall stop:)
		(eggSplatting play:)
		(egg dispose: delete:)
		(self setLoop: 9 setCel: 0 setCycle: End)
	)

	(method (onMe param1)
		(if (== param1 astroChicken)
			(return
				(and
					(<= (- nsLeft 15) (param1 x:) (- nsRight 10))
					(<= (- nsTop 75) (param1 y:) nsBottom)
				)
			)
		else
			(super onMe: param1 &rest)
		)
	)
)

(instance chickenWire of ScrollActor
	(properties
		y 150
		loop 11
		cel 13
	)

	(method (init)
		(self setCel: 13)
		(super init:)
	)

	(method (doChicken)
		(cornPicker play:)
		(astroChicken setLoop: 1 wireLeft: 3)
		(self setCel: 14)
	)
)

(instance theCage of Cage
	(properties
		top 20
		left 75
		bottom 118
		right 225
	)
)

(instance astroIndicator of View
	(properties
		x 16
		y 185
		view 290
		loop 11
		cel 12
		priority 15
		signal 16
	)
)

(instance egg of Actor
	(properties
		view 290
		priority 13
		signal 2064
	)

	(method (init)
		(super init:)
		(eggFall play:)
		(= x (astroChicken x:))
		(= y (+ (astroChicken y:) 5))
		(= local6 7)
		(= local7 1)
		(= local5 2)
		(self setLoop: 2 setCycle: Fwd)
	)

	(method (doit)
		(super doit:)
		(self posn: (+ x local6) (+ y local7))
		(if (not (-- local5))
			(-- local6)
			(++ local7)
			(if (>= y 150)
				((eggSplat new:) init:)
				(self dispose:)
			else
				(= local5 2)
			)
		)
	)
)

(instance eggSplat of Actor
	(properties
		y 155
		view 290
		loop 3
		priority 12
		signal 2064
		xStep 9
	)

	(method (init)
		(super init:)
		(eggFall stop:)
		(eggSplatting play:)
		(= x (egg x:))
		(self setCycle: End setMotion: MoveTo -5 y self)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance buckShot of Actor
	(properties
		yStep 9
		view 290
		loop 11
		cel 3
		signal 30720
		illegalBits 0
	)

	(method (init)
		(super init:)
		(= local2 0)
		(self
			posn: (crazedFarmer x:) 108
			setMotion: MoveTo (crazedFarmer x:) -18 self
		)
	)

	(method (doit)
		(super doit:)
		(if (and (astroChicken isNotHidden:) (astroChicken onMe: self))
			(gLongSong stop:)
			(winged play: astroChicken)
			(astroChicken hide: die:)
			(self dispose:)
		)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance henHouseLeft of Actor
	(properties
		x 500
		y 145
		view 290
		loop 11
		cel 8
		priority 3
		signal 22544
	)

	(method (doit)
		(super doit: &rest)
		(if (> x 169)
			(-= x 9)
		else
			(= x 160)
		)
	)
)

(instance henHouseRight of Actor
	(properties
		x 500
		y 145
		view 290
		loop 11
		cel 9
		priority 12
		signal 22544
	)

	(method (doit)
		(super doit: &rest)
		(if (> x 169)
			(-= x 9)
		else
			(= x 160)
		)
	)
)

(instance backok of Prop
	(properties
		x 100
		y 90
		view 290
		loop 14
	)
)

(instance astroChicken2 of Actor
	(properties
		view 290
		signal 2048
	)
)

(instance doHenHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(astroChicken2 setMotion: MoveTo 100 100 self)
			)
			(1
				(astroChicken2 setMotion: MoveTo 104 126 self)
			)
			(2
				(astroChicken2 setPri: 11 setMotion: MoveTo 171 126 self)
			)
			(3
				(backok init: setCycle: End self)
			)
			(4
				(gCurRoom newRoom: 376)
			)
		)
	)
)

