;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6150)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm6150 0
	dreamTalker 1
)

(local
	local0
)

(instance rm6150 of KQRoom
	(properties
		picture 6150
	)

	(method (init)
		(Load rsSOUND 6150)
		(Load rsVIEW 6151)
		(Load rsVIEW 6152)
		(super init:)
		(gGame handsOff:)
		(dreamSound number: 6150 loop: -1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 68 120 74 139 250 151 207 128 223 115 211 113 192 111 172 111 130 115 111 119 89 125
					yourself:
				)
		)
		(Load rsMESSAGE 6150)
		(Load rsVIEW 6151)
		(gEgo
			x: 160
			y: 230
			setScaler: Scaler 100 75 138 117
			init:
			normalize:
		)
		(weaver init:)
		(theLoom init:)
		(mySouthExit init:)
		(gCurRoom setScript: sComeIn)
	)
)

(instance sComeIn of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 3)
				)
				(1
					(gEgo setMotion: MoveTo 160 124 self)
				)
				(2
					(gEgo setHeading: 315 self)
				)
				(3
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gEgo posn: 160 124 normalize: 7)
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance talkToWeaver of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsVIEW 6152)
					(dream dispose:)
					(gEgo setHeading: 315)
					(weaver setScript: 0)
					(self cue:)
				)
				(1
					(weaver view: 6152 loop: 0 cel: 0 setCycle: End self)
				)
				(2
					(weaver view: 6152 loop: 1 cel: 0 setCycle: End self)
				)
				(3
					(cond
						((gEgo has: 70) ; Tapestry_of_Dreams
							(gMessager say: 1 8 4 0 self) ; "(HISSING, ALMOST SCARY)My sister is dearer to me than life itself! GO!"
						)
						((IsFlag 504)
							(gMessager say: 1 8 3 0 self) ; "(FAINTLY AMUSED, NOT ALL THAT NASTY)Go now, before I weave you a nightmare that will turn your hair white."
						)
						((IsFlag 505)
							(weaver setHotspot: 0)
							(weaver approachVerbs: 8 10 81 setHotspot: 8 10 81) ; Do, Exit, Dream_Catcher, Do, Exit, Dream_Catcher
							(SetFlag 504)
							(gMessager say: 1 8 2 0 self) ; "(INTENSE, UNNERVING)What do you want?"
						)
						(else
							(gMessager say: 1 8 1 0 self) ; "(TENTATIVLEY)Excuse me...hello?"
							(SetFlag 505)
							(weaver setHotspot: 0)
							(weaver setHotspot: 8 10 81) ; Do, Exit, Dream_Catcher
						)
					)
				)
				(4
					(weaver view: 6152 loop: 0 cel: 10 setCycle: Beg self)
				)
				(5
					(gEgo setHeading: 315 self)
				)
				(6
					(gGame handsOn:)
					(weaver setScript: weave)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(if (gCast contains: gEgo)
						(gEgo normalize: 7)
					)
					(if (gCast contains: weaver)
						(if (IsFlag 504)
							(weaver setHotspot: 0)
							(weaver approachVerbs: 8 10 81 setHotspot: 8 10 81) ; Do, Exit, Dream_Catcher, Do, Exit, Dream_Catcher
						)
						(weaver view: 6152 loop: 0 cel: 0 setScript: weave)
					)
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance talkToWeaverFirst of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsVIEW 6152)
					(dream dispose:)
					(weaver setScript: 0)
					(gEgo setHeading: 315 self)
				)
				(1
					(gMessager say: 1 8 1 0 self) ; "(TENTATIVLEY)Excuse me...hello?"
					(SetFlag 505)
				)
				(2
					(weaver view: 6152 loop: 0 cel: 0 setCycle: End self)
				)
				(3
					(weaver view: 6152 loop: 1 cel: 0 setCycle: End self)
				)
				(4
					(weaver view: 6152 loop: 0 cel: 10 setCycle: Beg self)
				)
				(5
					(gEgo setHeading: 315 self)
				)
				(6
					(gGame handsOn:)
					(weaver setScript: weave)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gEgo normalize: 7)
					(ClearFlag 539)
					(gGame handsOn:)
					(if (gCast contains: weaver)
						(weaver view: 6152 loop: 0 cel: 0 setScript: weave)
					)
					(self dispose:)
				)
			)
		)
	)
)

(instance weave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 6151
					loop: 0
					cel: 0
					x: 101
					y: 63
					cycleSpeed: 8
					setCycle: Fwd
				)
				(= seconds (Random 4 10))
			)
			(1
				(if local0
					(dream
						view: 6153
						loop: 4
						cel: 0
						x: 125
						y: 32
						init:
						setCycle: End self
					)
				else
					(dream
						view: 6151
						loop: 1
						cel: 0
						x: 125
						y: 32
						init:
						setCycle: End self
					)
				)
			)
			(2
				(if local0
					(dream view: 6153 loop: 5 cel: 0 setCycle: End self)
				else
					(dream view: 6151 loop: 2 cel: 0 setCycle: End self)
				)
			)
			(3
				(dream dispose:)
				(self changeState: 0)
			)
		)
	)
)

(instance getTapestry of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(dream dispose:)
					(SetFlag 209)
					(weaver setScript: 0)
					(Load rsVIEW 6152)
					(if (!= (gEgo heading:) 315)
						(gEgo setHeading: 315 self)
					else
						(= cycles 1)
					)
				)
				(1
					(weaver view: 6152 loop: 0 cel: 0 setCycle: End self)
				)
				(2
					(gMessager sayRange: 1 81 0 0 3 self) ; "(URGENT)Your aunts the Fates gave me this object to get past your nightmare. My business with you is most urgent."
				)
				(3
					(weaver view: 6152 loop: 1 cel: 0 setCycle: Fwd)
					(= cycles 10)
				)
				(4
					(weaver view: 6152 loop: 1 cel: 0 setCycle: End self)
				)
				(5
					(gMessager say: 1 81 0 4 self) ; "(FINALLY GIVING VALANICE HIS FULL ATTENTION, ALARMED)My precious sister is missing? You must go to Mab immediately! Wait I will give you something..."
				)
				(6
					(weaver view: 6152 loop: 0 cel: 10 setCycle: Beg self)
				)
				(7
					(Load rsVIEW 6151)
					(Load rsVIEW 6153)
					(= cycles 1)
				)
				(8
					(weaver view: 6151 loop: 0 cel: 0 setCycle: Fwd)
					(= cycles 10)
				)
				(9
					(tapestry init: setCycle: End self)
					(sparkSound number: 6153 loop: -1 play:)
				)
				(10
					(weaver view: 6152 loop: 0 cel: 0 setCycle: End self)
				)
				(11
					(weaver view: 6152 loop: 1 cel: 0 setCycle: End self)
				)
				(12
					(tapestry loop: 1 cel: 0 setCycle: End self)
				)
				(13
					(tapestry loop: 2 cel: 0 posn: 151 77 setCycle: Fwd)
					(gMessager say: 1 81 0 5 self) ; "(INTENSELY)When you ride this magical tapestry, you can travel through dreams in the flesh, but be warned! You will be vulnerable! Hurry, mortal, hurry!"
				)
				(14
					(tapestry loop: 3 cel: 0 setCycle: End self)
				)
				(15
					(sparkSound stop:)
					(tapestry dispose:)
					(gEgo get: 70) ; Tapestry_of_Dreams
					(weaver view: 6152 loop: 0 cel: 10 setCycle: Beg self)
				)
				(16
					(gEgo setHeading: 315 self)
				)
				(17
					(weaver setHotspot: 0)
					(weaver approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
					(weaver setScript: weave)
					(dreamSound number: 6151 loop: -1 play:)
					(Load rsSOUND 6151)
					(= local0 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gEgo loop: 7 get: 70 normalize:) ; Tapestry_of_Dreams
					(weaver setHotspot: 0)
					(weaver approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
					(weaver setScript: weave)
					(Load rsSOUND 6151)
					(= local0 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sSpark of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gEgo
						view: 6154
						loop: 0
						cel: 0
						setScale: 0
						setCycle: End self
					)
				)
				(1
					(sparkSound number: 6152 loop: -1 play:)
					(spark cel: 0 init: setCycle: End self)
				)
				(2
					(spark dispose:)
					(sparkSound stop:)
					(gEgo view: 6154 loop: 0 cel: 6 setCycle: Beg self)
				)
				(3
					(gEgo
						normalize:
						setScaler: Scaler 100 75 138 117
						setHeading: 315 self
					)
				)
				(4
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo normalize: 7)
					(if (gCast contains: spark)
						(spark dispose:)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 240 self)
			)
			(1
				(gCurRoom newRoom: 6100)
			)
		)
	)
)

(instance weaver of Actor
	(properties
		noun 1
		approachX 134
		approachY 121
		x 101
		y 63
		view 6151
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10 setScript: weave) ; Do, Exit, Do, Exit
		(if (IsFlag 505)
			(weaver setHotspot: 0)
			(weaver approachVerbs: 8 10 81 setHotspot: 8 10 81) ; Do, Exit, Dream_Catcher, Do, Exit, Dream_Catcher
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (not (IsFlag 505))
					(weaver setHotspot: 0)
					(weaver approachVerbs: 8 10 81 setHotspot: 8 10 81) ; Do, Exit, Dream_Catcher, Do, Exit, Dream_Catcher
					(gCurRoom setScript: talkToWeaverFirst)
				else
					(gCurRoom setScript: talkToWeaver)
				)
			)
			(81 ; Dream_Catcher
				(gCurRoom setScript: getTapestry)
			)
		)
	)
)

(instance spark of Prop
	(properties
		x 124
		y 78
		view 6154
		loop 1
	)
)

(instance dream of Prop
	(properties
		x 125
		y 32
		view 6151
		loop 1
	)
)

(instance tapestry of Prop
	(properties
		x 131
		y 25
		view 6153
	)
)

(instance theLoom of Feature
	(properties
		approachX 157
		approachY 123
		x 134
		y 59
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 10 ; Do, Exit
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 79 60 97 67 125 64 147 56 163 61 137 70 123 77 113 78 95 78 77 71 72 68 72 60 78 58
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(Load rsSOUND 6152)
				(Load rsVIEW 6154)
				(gCurRoom setScript: sSpark)
			)
		)
	)
)

(instance mySouthExit of ExitFeature
	(properties
		nsLeft 59
		nsTop 130
		nsRight 246
		nsBottom 135
		approachX 160
		approachY 200
		x 160
		y 160
		exitDir 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: sExitSouth)
		)
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)
)

(instance dreamSound of Sound
	(properties)
)

(instance sparkSound of Sound
	(properties)
)

(instance dreamTalker of KQTalker
	(properties
		clientCel -1
	)

	(method (init)
		(= client weaver)
		(super init: &rest)
	)
)

