;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use GloryTalker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm120 0
	sultanTalker 1
)

(instance rm120 of Rm
	(properties
		picture 120
		horizon 70
		picAngle 20
	)

	(method (init)
		(HandsOff)
		(self setRegions: 61) ; intro
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 152 280 117 251 118 222 107 197 107 180 81 143 82 144 101 135 102 135 108 123 130 80 116 80 189
					yourself:
				)
		)
		(LoadMany rsVIEW 122 123 125 960 32)
		(gEgo
			normalize:
			changeGait: 3
			setScale: Scaler 100 96 170 86
			setHeading: 315
			x: 234
			y: 164
			init:
		)
		(sultan init: stopUpd:)
		(jaafar init: stopUpd:)
		((ScriptID 34 1) view: 968 loop: 3 cel: 0 x: 155 y: 182 init: stopUpd:) ; Uhura
		((ScriptID 34 0) x: 196 y: 10 textX: -175 textY: 3 talkWidth: 140) ; uhuraTalker
		((ScriptID 35 1) view: 964 loop: 2 cel: 3 x: 141 y: 181 init: stopUpd:) ; Rakeesh
		(super init:)
		(self setScript: startUp)
	)

	(method (dispose)
		(UnLoad 128 122)
		(UnLoad 128 123)
		(UnLoad 128 125)
		(UnLoad 128 960)
		(UnLoad 128 32)
		(DisposeScript 35)
		(DisposeScript 34)
		(super dispose:)
	)
)

(instance startUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gLongSong number: 120 loop: -1 play:)
				(gMessager say: 1 6 1 0 self) ; "Palace of the Sultan of Shapeir Three days later..."
			)
			(2
				(sultan setCycle: End self)
			)
			(3
				(gMessager say: 2 6 2 0 self) ; "It greatly grieves me to say farewell to such fine friends and honored guests."
			)
			(4
				(gEgo setStep: 3 3 yStep: 3 setMotion: MoveTo 165 82 self)
			)
			(5
				(gEgo setHeading: 315)
				(cond
					((or (== gHeroType 0) (== gHeroType 3)) ; Fighter, Paladin
						(gMessager say: 2 6 3 0 self) ; "I send with you a special gift. I give you a magical shield which will help protect you from magical attacks. May you never need to use it."
					)
					((== gHeroType 2) ; Thief
						(gMessager say: 2 6 4 0 self) ; "I give you a special gift. Since you have shown such skill with ropes, I give you this set of magical grapnels. They will make any rope act as a magical rope and will grab and release at your command."
					)
					(else
						(gMessager say: 2 6 5 0 self) ; "My gift for your leaving comes from the gnome, Keapon Laffin. I asked him for something you would find useful. May it serve you well."
					)
				)
			)
			(6
				(sultan loop: 3 cel: 0 x: 156 y: 81 setCycle: End self)
			)
			(7
				(= ticks 60)
			)
			(8
				(sultan setCycle: Beg self)
			)
			(9
				(gLongSong2 number: 942 play:)
				(= cycles 10)
			)
			(10
				(sultan
					x: 159
					y: 82
					setPri: 3
					view: 123
					setCel: 0
					setLoop: 0
					setCycle: CT 4 1 self
				)
			)
			(11
				(gEgo hide:)
				(sultan setCycle: CT 5 1 self)
			)
			(12
				(= ticks 120)
			)
			(13
				(sultan cel: 6)
				(= cycles 5)
			)
			(14
				(gEgo show:)
				(sultan setCel: 7)
				(= cycles 5)
			)
			(15
				(sultan
					view: 121
					setLoop: 0
					setCel: (sultan lastCel:)
					x: 155
					y: 77
					stopUpd:
				)
				(gEgo
					setCycle: Rev
					setLoop: (gEgo loop:)
					setStep: 2 2
					xStep: 2
					yStep: 2
					setMotion: MoveTo 187 115 self
				)
			)
			(16
				(gEgo view: 32 setLoop: 1 cel: 0 x: 176 setCycle: End self)
			)
			(17
				(gEgo normalize: x: 182 y: 116 setHeading: 315)
				(gLongSong2 number: 932 setLoop: -1 play:)
				(portal ignoreActors: 1 cycleSpeed: 10 setCycle: Fwd init:)
				(= seconds 3)
			)
			(18
				(gMessager say: 3 6 6 0 self) ; "Sultan, the magical portal to Tarna appears."
			)
			(19
				(gEgo setMotion: PolyPath 90 116 self)
			)
			(20
				(gLongSong2 stop:)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance portal of Prop
	(properties
		x 61
		y 116
		view 125
	)
)

(instance sultan of Actor
	(properties
		x 155
		y 77
		view 121
		signal 16384
	)
)

(instance jaafar of Actor
	(properties
		x 113
		y 97
		view 120
	)
)

(instance sultanTalker of GloryTalker
	(properties
		x 5
		y 15
		view 122
		loop 1
		talkWidth 135
		back 57
		textX 140
		textY 3
	)

	(method (init)
		(super init: sultanBust sultanEyes sultanMouth &rest)
	)
)

(instance sultanBust of Prop
	(properties
		nsTop 22
		nsLeft 40
		view 122
		loop 3
	)
)

(instance sultanMouth of Prop
	(properties
		nsTop 51
		nsLeft 41
		view 122
		cycleSpeed 10
	)
)

(instance sultanEyes of Prop
	(properties
		nsTop 40
		nsLeft 43
		view 122
		loop 2
		cycleSpeed 30
	)
)

