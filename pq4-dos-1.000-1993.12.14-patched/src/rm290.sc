;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use Plane)
(use Print)
(use Talker)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm290 0
)

(local
	local0
)

(instance rm290 of Room
	(properties
		picture 0
	)

	(method (init)
		(Palette 2 0 239 0) ; PalIntensity
		(= local0 gNarrator)
		(= gNarrator kbTalk)
		(gTheIconBar disable:)
		(gThePlane setRect: 0 0 319 199)
		(super init:)
		(Load rsVIEW 802)
		(Load rsVIEW 803)
		(Load rsVIEW 8000)
		(Load rsVIEW 8001)
		(Load rsVIEW 8002)
		(Load rsVIEW 8003)
		(Load rsVIEW 8004)
		(Load rsVIEW 8005)
		(kristy init:)
		(gGame intensity: 0)
		(gTheCursor hide:)
		(gGlobalSound0 number: 505 setLoop: 1 play: hold: 1)
		(kHead init:)
		(self setScript: montage)
	)

	(method (dispose)
		(gTheCursor show:)
		(Palette 2 0 68 100) ; PalIntensity
		(gTheIconBar enable:)
		(gThePlane setRect: 0 0 319 152)
		(gGame intensity: 100)
		(= gNarrator local0)
		(super dispose:)
	)
)

(instance runPictures of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 300)
			)
			(1
				(self setScript: fadeUp)
				(baby view: 802 loop: 0 cel: 0 init: setCycle: End self)
			)
			(2
				(baby loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(baby view: 803 loop: 0 cel: 0 setCycle: End)
				(self setScript: fadeDown self)
			)
			(4
				(baby dispose:)
				(= cycles 2)
			)
			(5
				(= ticks 300)
			)
			(6
				(self setScript: fadeUp)
				(rod view: 8003 loop: 0 cel: 0 init: cel: 0 setCycle: End self)
			)
			(7
				(rod loop: 1 cel: 0 setCycle: End self)
			)
			(8
				(rod view: 8004 loop: 0 cel: 0 setCycle: End self)
			)
			(9
				(rod loop: 1 cel: 0 setCycle: End)
				(self setScript: fadeDown self)
			)
			(10
				(rod dispose:)
				(= cycles 2)
			)
			(11
				(= ticks 300)
			)
			(12
				(door init:)
				(self setScript: fadeUp)
				(= ticks 60)
			)
			(13
				(tammy
					view: 8001
					loop: 0
					cel: 0
					init:
					cel: 0
					setCycle: End self
				)
			)
			(14
				(tammy loop: 1 cel: 0 setCycle: End self)
			)
			(15
				(tammy view: 8002 loop: 0 cel: 0 setCycle: End self)
			)
			(16
				(tammy loop: 1 cel: 0 setCycle: End self)
			)
			(17
				(self setScript: fadeDown self)
			)
			(18
				(tammy dispose:)
				(door dispose:)
				(self dispose:)
			)
		)
	)
)

(instance montage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(self setScript: fadeUp self)
			)
			(1
				1
				(kHead setCycle: Fwd)
				(gMessager say: 1 2 0 1 self) ; "In the wake of this city's worst nightmare, five people, including two Los Angeles police officers, have been found mutilated and murdered."
			)
			(2
				2
				(kHead cel: 0 setCycle: 0)
				(= ticks 30)
			)
			(3
				3
				(kHead setCycle: Fwd)
				(gMessager say: 1 2 0 2 self) ; "And though City officials and the LAPD deny there is reason to panic, the citizens of Los Angeles feel quite differently."
				(self setScript: runPictures)
			)
			(4
				4
				(kHead cel: 0 setCycle: 0)
				(= ticks 10)
			)
			(5
				5
				(kHead setCycle: Fwd)
				(gMessager say: 1 2 0 3 self) ; "Gun sales are up and security companies are deluged with requests for home alarm systems."
			)
			(6
				6
				(kHead cel: 0 setCycle: 0)
				(= ticks 10)
			)
			(7
				7
				(kHead setCycle: Fwd)
				(gMessager say: 1 2 0 4 self) ; "Factors contributing to the urgency and concern by LA residents are the randomness and violence of these murders."
			)
			(8
				8
				(kHead cel: 0 setCycle: 0)
				(= ticks 10)
			)
			(9
				9
				(kHead setCycle: Fwd)
				(gMessager say: 1 2 0 5 self) ; "Earlier today, I spoke with Sherry Moore, a LA County Coroner's employee, who confirmed one element of this killing spree."
			)
			(10
				10
				(kHead cel: 0 setCycle: 0)
				(= ticks 10)
			)
			(11
				11
				(kHead setCycle: Fwd)
				(gMessager say: 1 2 0 6 self) ; "Evidence found on the latest male victim indicates that the murders might have been committed by a woman."
			)
			(12
				12
				(kHead cel: 0 setCycle: 0)
				(= ticks 10)
			)
			(13
				13
				(kHead setCycle: Fwd)
				(gMessager say: 1 2 0 7 self) ; "If true, then this is the first case in the history of Los Angeles where a female serial killer has held the City in her grip. I'm Kristy Bilden reporting for KKAT."
			)
			(14
				14
				(kHead cel: 0 setCycle: 0)
				(= ticks 20)
				(gGlobalSound0 hold: 2 client: self)
			)
			(15
				15
				(gGlobalSound0 number: 507 play: hold: 1)
				(self setScript: fadeDown self)
			)
			(16
				16
				(gCast
					eachElementDo: #dispose
					eachElementDo: #delete
					release:
				)
				(FrameOut)
				(= cycles 10)
			)
			(17
				17
				(gGame fadeSpeed: 1)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance fadeDown of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 100)
	)

	(method (doit)
		(if register
			(-= register 5)
			(if (== (montage state:) 15)
				(Palette 2 0 135 register) ; PalIntensity
			else
				(Palette 2 136 239 register) ; PalIntensity
			)
			(FrameOut)
		else
			(self dispose:)
		)
	)
)

(instance fadeUp of Script
	(properties)

	(method (init)
		(= caller 0)
		(super init: &rest)
		(= register 0)
	)

	(method (doit)
		(if (<= register 100)
			(if caller
				(if (== (montage state:) 0)
					(Palette 2 0 135 register) ; PalIntensity
				else
					(Palette 2 136 239 register) ; PalIntensity
				)
			else
				(Palette 2 136 239 register) ; PalIntensity
			)
			(FrameOut)
			(+= register 5)
		else
			(self dispose:)
		)
	)
)

(instance kbTalk of Narrator
	(properties
		x 26
		y 157
		modeless 2
		fore 64
	)

	(method (display param1 &tmp temp0 temp1)
		(= temp1 (Print new:))
		(temp1
			shadowText: 0
			fore: fore
			back: back
			plane: myPlane
			posn: x y
			font: font
			width: talkWidth
			addText: param1
			modeless: 2
			init:
		)
		(gPrints delete: temp1)
		(= dialog (temp1 dialog:))
	)

	(method (handleEvent event)
		(event claimed: 1)
	)
)

(instance kristy of Prop
	(properties
		x 130
		y 150
		view 8005
	)
)

(instance kHead of Prop
	(properties
		x 130
		y 150
		view 8005
		loop 1
	)

	(method (init)
		(super init: &rest)
		(|= signal $4000)
	)
)

(instance rod of Prop
	(properties
		x 45
		y 75
		view 8003
	)
)

(instance baby of Prop
	(properties
		x 212
		y 60
		view 802
	)
)

(instance door of View
	(properties
		x 270
		y 152
		fixPriority 1
		view 8000
	)
)

(instance tammy of Prop
	(properties
		x 270
		y 152
		priority 1
		fixPriority 1
		view 8001
	)

	(method (init)
		(super init: &rest)
		(|= signal $4000)
	)
)

(instance myPlane of Plane
	(properties
		picture -2
	)

	(method (init)
		(= picture -2)
		(super init: &rest)
		(FrameOut)
	)
)

