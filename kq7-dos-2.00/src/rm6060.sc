;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6060)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Talker)
(use RandCycle)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm6060 0
	lachesisTalker 1
	clothoTalker 2
	atroposTalker 3
	valTalker 4
)

(local
	local0
	local1
	[local2 16] = [0 0 12 12 0 4 -9 7 -11 2 -1 10 3 6 1 3]
)

(instance rm6060 of KQRoom
	(properties
		picture 6060
	)

	(method (init &tmp temp0 temp1 temp2)
		(Load rsMESSAGE 6060)
		(Load rsVIEW 6061)
		(= temp0 0)
		(for ((= temp1 1)) (< temp1 16) ((+= temp1 2))
			(+= [local2 temp0] 262)
			(+= [local2 temp1] 92)
			(+= temp0 2)
		)
		(SetFlag 21)
		(super init: &rest)
		(gEgo
			x: 274
			y: 90
			view: 6061
			loop: 0
			cel: 0
			init:
			setScale: 0
			disableHotspot:
		)
		(++ global125)
		(Atropos init: setScript: (fatesIdle new:))
		(Clotho init: setScript: (fatesIdle new:))
		(Lachesis init: setScript: (fatesIdle new:))
		(starFire1 init: setCycle: RandCycle)
		(starFire2 init: setPri: (+ (starFire1 priority:) 1) setCycle: Fwd)
		(gKqMusic1 number: 6060 setLoop: -1 play: setVol: 0 fade: 127 25 10 0)
		(if (and (gEgo has: 69) (IsFlag 210)) ; Magic_Bridle
			(gCurRoom setScript: fatesPissed)
		else
			(gCurRoom setScript: valFromWall)
		)
	)

	(method (dispose)
		(gKqMusic1 fade: 0 25 10 1)
		(gUser canControl: 1)
		((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
		(gEgo enableHotspot:)
		(super dispose: &rest)
	)
)

(instance valIntoWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gGame isHandsOn:)
					(gGame handsOff:)
				)
				(Load rsVIEW 6062)
				(Load rsSOUND 108)
				(= ticks 60)
			)
			(1
				(if (== local1 2)
					(Atropos
						setScript: 0
						view: 6063
						loop: 0
						cel: 0
						setCycle: End self
					)
				else
					(Atropos setScript: 0)
					(++ state)
					(= ticks 1)
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(Atropos view: 6062 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(Atropos setScript: (fatesIdle new:))
				(gKqSound1 number: 108 setLoop: 1 play:)
				(gEgo
					view: 6062
					loop: 1
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(5
				(gEgo hide:)
				(= cycles 2)
			)
			(6
				(gGame handsOn:)
				(gCurRoom newRoom: 6050)
				(self dispose:)
			)
		)
	)
)

(instance valFromWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gGame isHandsOn:)
					(gGame handsOff:)
				)
				(Load rsSOUND 108)
				(= ticks 60)
			)
			(1
				(gKqSound1 number: 108 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo
					x: 262
					y: 92
					view: 6061
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo
					view: 6061
					setLoop: 2 1
					cel: 0
					setSpeed: 16
					setStep: 1 1 1
					setCycle: Fwd
					setScript: valFloats
				)
				(gGame handsOn:)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance valFloats of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random 30 60))
			)
			(1
				(= temp0 (* 8 (Random 0 1)))
				(client
					setMotion:
						DPath
						[local2 (+ temp0 0)]
						[local2 (+ temp0 1)]
						[local2 (+ temp0 2)]
						[local2 (+ temp0 3)]
						[local2 (+ temp0 4)]
						[local2 (+ temp0 5)]
						[local2 (+ temp0 6)]
						[local2 (+ temp0 7)]
						self
				)
			)
			(2
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance fatesIdle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 30 60))
			)
			(1
				(client view: 6067 setCycle: End self)
			)
			(2
				(client cel: 0)
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance talkToFates of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gGame isHandsOn:)
					(gGame handsOff:)
				)
				(= seconds 1)
			)
			(1
				(cond
					((and (gEgo has: 69) (IsFlag 210)) ; Magic_Bridle
						(gMessager say: 1 8 10 0 self) ; "(COLDLY)Understand, mortal, the threads of the very world fray in our hands. Soon your little problem will matter no more than a speck of dust in a hurricane. Begone!"
						(= local1 1)
					)
					((and (IsFlag 565) (not (IsFlag 209)))
						(gMessager say: 1 8 9 0 self) ; "How can I find this Weaver of Dreams?"
						(= local1 1)
					)
					((and (IsFlag 206) (not (IsFlag 565)) (IsFlag 544))
						(= local1 1)
						(gCurRoom setScript: valGetsDreamCatcher)
					)
					((and (IsFlag 206) (IsFlag 565))
						(= local1 2)
						(= ticks 1)
					)
					((== global126 1)
						(gMessager say: 1 8 6 0 self) ; "(TERRIBLY WORRIED)Madam Fates, I MUST find a way to speak to Mab! Is there nothing you can do?"
						(++ global126)
						(= local1 1)
					)
					((== global126 2)
						(gMessager say: 1 8 7 0 self) ; "(DESPERATE, ANGRY)You must help me! My daughter's life hangs in the balance!"
						(++ global126)
						(= local1 1)
					)
					((> global126 2)
						(= local1 2)
						(= ticks 1)
					)
					((IsFlag 207)
						(gMessager say: 1 8 5 0 self) ; "(TERRIBLY WORRIED)I have seen Mab! She has been frozen into a lifeless statue of ice!"
						(++ global126)
						(= local1 1)
					)
					((== global125 1)
						(if (not local0)
							(= local0 1)
							(gMessager sayRange: 1 8 1 1 6 self) ; "(CAUTIOUS, EXTREMELY POLIT)Who...who are you?"
							(= local1 0)
						else
							(gMessager say: 1 8 2 0 self) ; "(VERY RESPECTFUL BUT URGENT)My daughter is imprisoned by Malicia, and I fear for her life. I must see Oberon and Titania immediately."
							(SetFlag 511)
							(= local1 1)
						)
					)
					((== global125 2)
						(gMessager say: 1 8 3 0 self) ; ""(ANGRY)I came to you for help, and you gave me riddles! If Mab cannot be reached in the waking world, she cannot be reached at all!"
						(= local1 1)
					)
					((== global125 3)
						(gMessager say: 1 8 4 0 self) ; "(DESPERATE)Please, great ladies, I am filled with too much fear for my daughter to sleep. What am I to do?"
						(= local1 1)
					)
					((>= global125 4)
						(= local1 2)
						(= ticks 1)
					)
				)
			)
			(2
				(gGame handsOn:)
				(gUser canControl: 0)
				(if local1
					(gCurRoom setScript: valIntoWall)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance valGetsDreamCatcher of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gGame isHandsOn:)
					(gGame handsOff:)
				)
				(gMessager sayRange: 1 8 8 1 4 self) ; "(WORRIED)I have seen Ceres, and she has told me that I must enter the land of dreams while awake. How can I do this, great ladies?"
			)
			(1
				(Lachesis
					view: 6064
					loop: 0
					cel: 0
					setCycle: End self
					setScript: 0
				)
			)
			(2
				(dreamCatcher init: setCycle: End self)
				(gKqSound1 number: 819 setLoop: 1 play: setVol: 127)
				(gEgo setScript: 0 setMotion: MoveTo 262 92)
			)
			(3
				(gEgo
					view: 6064
					loop: 2
					cel: 0
					setSpeed: 10
					setCycle: CT 2 1 self
				)
			)
			(4
				(= cycles 5)
			)
			(5
				(dreamCatcher hide:)
				(gEgo cel: 3 setCycle: End self)
				(UpdateScreenItem gEgo)
			)
			(6
				(Lachesis
					view: 6065
					loop: 0
					cel: 0
					x: 117
					y: 96
					setCycle: End self
				)
				(gEgo setSpeed: 16 setScript: valFloats)
			)
			(7
				(gMessager say: 1 8 8 5 self) ; "You will need this. It sometimes pleases our nephew to surround himself with the darkest terrors of night. Farewell, Valanice."
			)
			(8
				(Lachesis setCycle: Beg self)
				(gEgo get: 68) ; Dream_Catcher
				(SetFlag 565)
			)
			(9
				(Lachesis setScript: (fatesIdle new:))
				(gGame handsOn:)
				(gUser canControl: 0)
				(gCurRoom setScript: valIntoWall)
				(self dispose:)
			)
		)
	)
)

(instance fatesPissed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gGame isHandsOn:)
					(gGame handsOff:)
				)
				(Load rsVIEW 6062)
				(Load rsVIEW 6063)
				(Load rsVIEW 6065)
				(= ticks 60)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gEgo
					x: 262
					y: 92
					view: 6061
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(3
				(Atropos
					view: 6063
					loop: 0
					cel: 0
					setCycle: End self
					setScript: 0
				)
				(Lachesis
					view: 6065
					loop: 0
					cel: 0
					setCycle: End self
					setScript: 0
				)
				(Clotho
					view: 6065
					loop: 1
					cel: 0
					setCycle: End self
					setScript: 0
				)
			)
			(4)
			(5)
			(6
				(= ticks 30)
			)
			(7
				(gMessager say: 1 8 10 0 self) ; "(COLDLY)Understand, mortal, the threads of the very world fray in our hands. Soon your little problem will matter no more than a speck of dust in a hurricane. Begone!"
			)
			(8
				(Atropos view: 6062 loop: 0 cel: 0 setCycle: End self)
			)
			(9
				(Atropos setScript: (fatesIdle new:))
				(gEgo
					view: 6062
					loop: 1
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(10
				(gGame handsOn:)
				(gCurRoom newRoom: 6050)
				(self dispose:)
			)
		)
	)
)

(instance dreamCatcher of Actor
	(properties
		x 184
		y 55
		priority 100
		fixPriority 1
		view 6064
		loop 1
		signal 2049
	)
)

(instance Atropos of Prop
	(properties
		noun 1
		x 125
		y 46
		fixPriority 1
		view 6067
		signal 2049
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: talkToFates)
			)
		)
	)
)

(instance Clotho of Prop
	(properties
		noun 1
		x 183
		y 63
		priority 98
		fixPriority 1
		view 6067
		loop 1
		signal 2049
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: talkToFates)
			)
		)
	)
)

(instance Lachesis of Prop
	(properties
		noun 1
		x 118
		y 95
		fixPriority 1
		view 6067
		loop 2
		signal 2049
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: talkToFates)
			)
		)
	)
)

(instance starFire1 of Prop
	(properties
		x 127
		y 89
		priority 87
		fixPriority 1
		view 6060
		loop 1
	)
)

(instance starFire2 of Prop
	(properties
		x 127
		y 89
		view 6060
	)
)

(class FatesTalker of KQTalker
	(properties
		theScript 0
	)

	(method (doBefore))

	(method (doNext))

	(method (init)
		(= theScript (client script:))
		(client script: 0)
		(self doBefore:)
		(while 1
			(if (client cycler:)
				(gCast doit:)
			else
				(break)
			)
			(gSounds eachElementDo: #check)
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
		)
		(super init: &rest)
	)

	(method (dispose param1)
		(super dispose: param1)
		(if (or (not argc) param1)
			(client setCycle: Beg)
			(while 1
				(if (client cycler:)
					(gCast doit:)
				else
					(break)
				)
				(gSounds eachElementDo: #check)
				(= gGameTime (+ gTickOffset (GetTime)))
				(FrameOut)
			)
			(self doNext:)
			(client script: theScript)
		)
	)
)

(instance lachesisTalker of FatesTalker
	(properties
		clientCel -1
	)

	(method (init)
		(self client: Lachesis)
		(super init: &rest)
	)

	(method (doBefore)
		(client view: 6065 setLoop: 0 cel: 0 x: 117 y: 96 setCycle: End)
	)

	(method (doNext)
		(client view: 6067 loop: 2 cel: 0)
	)
)

(instance atroposTalker of FatesTalker
	(properties
		clientCel 7
	)

	(method (init)
		(self client: Atropos)
		(super init: &rest)
	)

	(method (doBefore)
		(client view: 6067 setLoop: 0 cel: 0 setCycle: CT 7 1)
	)

	(method (doNext)
		(client view: 6067 loop: 0 cel: 0)
	)
)

(instance valTalker of FatesTalker
	(properties
		clientCel 0
	)

	(method (init)
		(self client: gEgo)
		(super init: &rest)
		(theScript state: -1 ticks: 1)
	)

	(method (doBefore)
		(client setMotion: 0 setCycle: CT 0 -1)
	)

	(method (doNext)
		(client setCycle: Fwd)
	)
)

(instance clothoTalker of KQTalker
	(properties
		clientCel -1
	)

	(method (init)
		(= client Clotho)
		(super init: &rest)
	)
)

