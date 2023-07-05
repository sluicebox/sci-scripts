;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 820)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use TrackingProp)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm820 0
)

(local
	local0
	local1
	local2
)

(instance rm820 of LightRoom
	(properties
		picture 2813
	)

	(method (init)
		(= local1 global245)
		(gGame handsOn:)
		(super init: &rest)
		(gBackMusic number: 8002 setLoop: -1 play:)
		(gMySoundFX number: 833 setLoop: -1 play:)
		(scriptObj init:)
		(switch gPrevRoomNum
			(270
				(self changeScene: 2810 3)
			)
			(else
				(self changeScene: 2810 3)
			)
		)
	)

	(method (changeScene param1)
		(leftLever dispose:)
		(rightLever dispose:)
		(leftPipeValve dispose:)
		(vertPipeValve dispose:)
		(leftDial dispose:)
		(rightDial dispose:)
		(craneButton dispose:)
		(cageLever dispose:)
		(fUmbrellaHole dispose:)
		(vTrainGate dispose:)
		(theBaby dispose:)
		(theCrane dispose:)
		(theTrain dispose:)
		(pUmbrellaProp dispose:)
		(fUmbrella dispose:)
		(fOpenTheGate dispose:)
		(trainSound stop:)
		(if (and (scriptObj script:) (== (scriptObj script:) sOpenTheGate))
			(scriptObj setScript: 0)
		)
		(if local0
			(= global245 (rockBot curFrame:))
			(rockBot caller: 0 dispose:)
		)
		(super changeScene: param1 &rest)
		(switch param1
			(2810
				((ScriptID 1 1) newRoom: 270) ; exitForward
				((ScriptID 1 4) newPic: 2813 1) ; exitRight
				((ScriptID 1 3) newPic: 2811 5) ; exitLeft
				((ScriptID 1 2) newPic: 2812 7) ; exitBack
				(if (== global237 2)
					(theTrain cel: 0 init:)
				else
					(theTrain cel: 1 init:)
				)
				(if (IsFlag 402)
					(trainSound play: 65 0)
				)
			)
			(2811
				((ScriptID 1 3) newPic: 2812 7) ; exitLeft
				((ScriptID 1 4) newPic: 2810 3) ; exitRight
				((ScriptID 1 2) newPic: 2813 1) ; exitBack
				(switch global243
					(1
						(theCrane view: 2819 loop: 0 cel: 9 x: 37 y: 179 init:)
					)
					(4
						(theCrane view: 2819 loop: 1 cel: 24 x: 37 y: 179 init:)
					)
				)
			)
			(2812
				((ScriptID 1 3) newPic: 2814 8) ; exitLeft
				((ScriptID 1 4) newPic: 2811 5) ; exitRight
				((ScriptID 1 2) newPic: 2810 3) ; exitBack
			)
			(2813
				((ScriptID 1 3) newPic: 2810 3) ; exitLeft
				((ScriptID 1 4) newPic: 2814 8) ; exitRight
				((ScriptID 1 2) newPic: 2811 5 nsLeft: 190) ; exitBack
				(leftLever init:)
				(if (IsFlag 363)
					(leftLever setCel: 10)
				else
					(leftLever setCel: 0)
				)
				(rightLever
					cel: 5
					init:
					setPoints:
						-3
						-16
						-2
						-20
						-1
						-24
						0
						-28
						1
						-32
						2
						-36
						3
						-41
						4
						-44
						5
						-47
						6
						-50
						7
						-53
				)
				(leftPipeValve init:)
				(vertPipeValve init:)
				(leftDial init:)
				(rightDial init:)
				(if (and (IsFlag 361) (IsFlag 269))
					(SetFlag 358)
				else
					(ClearFlag 358)
				)
				(if (IsFlag 358)
					(leftDial setCel: 6)
					(leftPipeValve setCel: 0)
				else
					(leftDial setCel: 0)
					(leftPipeValve setCel: 9)
				)
				(if (and (IsFlag 362) (IsFlag 268))
					(SetFlag 359)
				else
					(ClearFlag 359)
				)
				(if (IsFlag 359)
					(rightDial setCel: 6)
					(vertPipeValve setCel: 0)
				else
					(rightDial setCel: 0)
					(vertPipeValve setCel: 9)
				)
				(craneButton init:)
				(cageLever init:)
				(if (not (IsFlag 377))
					(theBaby view: 121 x: 184 y: 145 init:)
					(if (not (IsFlag 270))
						(theBaby setCycle: Fwd)
					)
				)
				(switch global243
					(2
						(theCrane view: 2817 loop: 4 cel: 10 x: 300 y: 1 init:)
					)
					(5
						(theCrane
							view: 2817
							loop: 5
							cel: 24
							x: 362
							y: 128
							init:
						)
					)
				)
			)
			(2814
				(if (IsFlag 396)
					(moveThruGate newPic: 2815 4)
				)
				((ScriptID 1 3) newPic: 2813 1) ; exitLeft
				((ScriptID 1 4) newPic: 2812 7) ; exitRight
			)
			(2815
				((ScriptID 1 3) newPic: 2811 5) ; exitLeft
				(if (not (IsFlag 301))
					(vTrainGate init:)
				)
				(cond
					((and (IsFlag 377) (not (IsFlag 378)))
						(theBaby
							view: 117
							x: 53
							y: 299
							init:
							setScript: sBabyRandom
						)
					)
					((IsFlag 378)
						(theBaby view: 117 loop: 1 x: 53 y: 299 init:)
					)
					(else
						(theBaby view: 115 x: 247 y: 75 init:)
						(if (not (IsFlag 270))
							(theBaby setCycle: Fwd)
						)
					)
				)
			)
		)
		(if (OneOf param1 2811 2812 2813 2814)
			(if (== (gCurRoom script:) incFrames)
				(incFrames dispose:)
			)
			(switch param1
				(2811
					(rockBot init: 2819 0 0 0 -1)
				)
				(2812
					(rockBot init: 2820 0 0 0 -1)
				)
				(2813
					(rockBot init: 2817 0 0 0 -1)
				)
				(2814
					(cond
						((not (IsFlag 377))
							(if (IsFlag 396)
								(rockBot init: 2822 0 0 0 -1)
								(pUmbrellaProp cel: 3 setPri: 300 init:)
								(fUmbrella init:)
							else
								(rockBot init: 2821 0 0 0 -1)
								(fUmbrellaHole init:)
							)
						)
						((IsFlag 396)
							(= global245 2)
							(rockBot init: 2823 0 0 0 -1)
							(pUmbrellaProp cel: 3 setPri: 300 init:)
							(fUmbrella init:)
						)
						(else
							(= global245 0)
							(rockBot init: 2823 0 0 0 -1)
							(fOpenTheGate init:)
						)
					)
				)
			)
			(rockBot curFrame: global245)
			(Robot 1 global245 (rockBot x:) (rockBot y:)) ; DisplayFrame
			(if (and (IsFlag 270) (not (IsFlag 377)))
				(rockBot start: 1 10 1)
			)
			(= local0 1)
		else
			(if
				(and
					(IsFlag 270)
					(!= (gCurRoom script:) incFrames)
					(not (IsFlag 377))
				)
				(self setScript: incFrames)
			)
			(= local0 0)
		)
	)

	(method (notify)
		(if local0
			(= global245 (rockBot curFrame:))
			(rockBot caller: 0 dispose:)
			(= local0 0)
		)
		(scriptObj setScript: 0)
		(theBaby setScript: 0)
		(self setScript: 0)
		(ClearFlag 270)
	)

	(method (doit)
		(if local0
			(= global245 (rockBot curFrame:))
		)
		(if
			(and
				(or (== scene 2813) (== scene 2815))
				(not (IsFlag 377))
				(IsFlag 270)
				(!= global245 local2)
			)
			(= local2 global245)
			(theBaby setCel: global245)
			(if (OneOf global245 1 40 79)
				(hornSound number: 838 play:)
			)
			(if (OneOf global245 13 53 91)
				(hornSound number: 8381 play:)
			)
		)
		(if (and (IsFlag 270) (!= global245 local1))
			(= local1 global245)
			(if (and (not (IsFlag 377)) (OneOf global245 1 40 79))
				(beltSound play:)
			)
			(if (and (== scene 2811) (OneOf global245 1 40 80))
				(swingDoorSound play:)
			)
			(if
				(and
					(== (rockBot number:) 2821)
					(OneOf global245 6 45 84)
				)
				(gateSlamSound play:)
			)
			(if
				(or
					(and
						(== (rockBot number:) 2822)
						(OneOf global245 9 48 87)
					)
					(and
						(== (rockBot number:) 2817)
						(OneOf global245 15 54 93)
					)
				)
				(rockSmashSound play:)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(gBackMusic fade:)
		(gMySoundFX fade:)
		(trainSound fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance scriptObj of Prop
	(properties
		x -500
		view 0
	)
)

(instance rockBot of RobotPlayer
	(properties)
)

(instance incFrames of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= global245 116)
					(= global245 0)
				else
					(++ global245)
				)
				(= ticks 10)
			)
			(1
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance sBackEmpty of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gCurRoom changeScene: 2811 5)
				(theCrane
					view: 2819
					loop: 0
					x: 37
					y: 179
					cycleSpeed: 9
					init:
					setCycle: End self
				)
				(craneSound play:)
			)
			(2
				(craneSound stop:)
				(= global243 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLiftRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gCurRoom changeScene: 2811 5)
				(theCrane
					setLoop: 1
					setCel: 0
					cycleSpeed: 6
					setCycle: CT 11 1 self
				)
				(craneSound play:)
			)
			(2
				(cond
					((IsFlag 377)
						(theCrane setCycle: Beg self)
					)
					((or (< global245 47) (> global245 77))
						(theCrane setCycle: Beg self)
					)
					(else
						(theCrane setCycle: End self)
						(= global243 4)
					)
				)
			)
			(3
				(craneSound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDropRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(Load rsVIEW 120)
				(Load rsAUDIO 842)
				(craneSound number: 936 setLoop: 1 play:)
				(theCrane
					setLoop: 6
					setCel: 0
					cycleSpeed: 6
					setCycle: CT 1 1 self
				)
			)
			(2
				(theCrane setCycle: End self)
				(cageLever dispose:)
			)
			(3
				(craneSound number: 934 setLoop: -1 stop:)
				(cageLever init:)
				(theCrane setLoop: 4 setCel: 10 x: 300 y: 1)
				(= global243 2)
				(rockBot stop:)
				(SetFlag 377)
				(self cue:)
			)
			(4
				(theBaby view: 120 setLoop: 0 setCel: 0 setCycle: End self)
				(babySound2 play:)
			)
			(5
				(= global245 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCenterBackFull of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gCurRoom changeScene: 2811 5)
				(theCrane
					view: 2819
					loop: 2
					cel: 14
					x: 37
					y: 179
					cycleSpeed: 9
					init:
					setCycle: Beg self
				)
				(craneSound play:)
			)
			(2
				(craneSound stop:)
				(= global243 4)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBackCenterFull of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gCurRoom changeScene: 2811 5)
				(theCrane
					setLoop: 2
					setCel: 0
					x: 37
					y: 179
					cycleSpeed: 9
					setCycle: End self
				)
				(craneSound play:)
			)
			(2
				(craneSound stop:)
				(theCrane dispose:)
				(= global243 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBackCenterEmpty of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(craneSound play:)
				(gCurRoom changeScene: 2811 5)
				(theCrane cycleSpeed: 9 setCycle: Beg self)
			)
			(2
				(craneSound stop:)
				(theCrane dispose:)
				(= global243 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCenterForwardEmpty of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theCrane
					view: 2817
					loop: 4
					cel: 0
					x: 300
					y: 1
					cycleSpeed: 9
					init:
					setCycle: End self
				)
				(craneSound play:)
			)
			(1
				(craneSound stop:)
				(= global243 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCenterForwardFull of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theCrane
					view: 2817
					loop: 5
					cel: 0
					x: 362
					y: 128
					cycleSpeed: 9
					init:
					setCycle: End self
				)
				(craneSound play:)
			)
			(1
				(craneSound stop:)
				(= global243 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sForwardCenterFull of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(theCrane cycleSpeed: 9 setCycle: Beg self)
				(craneSound play:)
			)
			(2
				(craneSound stop:)
				(= global243 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sForwardCenterEmpty of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(craneSound play:)
				(theCrane cycleSpeed: 9 setCycle: Beg self)
			)
			(2
				(craneSound stop:)
				(= global243 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theTrain of View
	(properties
		x 229
		y 74
		view 2808
	)
)

(instance theCrane of Prop
	(properties
		view 2819
	)

	(method (init)
		(self setPri: 300)
		(super init: &rest)
	)
)

(instance theBaby of Prop
	(properties
		x 184
		y 145
		view 121
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (IsFlag 377) (!= loop 1)) ; Do
			(SetFlag 378)
			(SetFlag 350)
			(self setScript: 0 setLoop: 1)
			(gInventory addItem: (ScriptID 9 36)) ; invAmanda
		)
	)
)

(instance leftLever of Prop
	(properties
		x 97
		y 276
		cel 5
		view 2817
	)

	(method (cue)
		(if cel
			(SetFlag 363)
			(if (and (IsFlag 358) (IsFlag 301))
				(ClearFlag 301)
				(gateSound number: 8431 play:)
			)
		else
			(ClearFlag 363)
			(if (not (IsFlag 301))
				(SetFlag 301)
				(gateSound number: 938 play:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					(cycler
						(if (== (cycler cycleDir:) 1)
							(self setCycle: Beg self)
							(localSound number: 844 play:)
						else
							(self setCycle: End self)
							(localSound number: 843 play:)
						)
					)
					(cel
						(self setCycle: Beg self)
						(localSound number: 844 play:)
					)
					(else
						(self setCycle: End self)
						(localSound number: 843 play:)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightLever of TrackingProp
	(properties
		x 166
		y 276
		loop 1
		view 2817
		wrap 0
	)

	(method (init)
		(super init: &rest)
		(&= signal $efff)
	)

	(method (doMouseUp)
		(if (> cel 5)
			(self setCycle: CT 5 -1)
		else
			(self setCycle: CT 5 1)
		)
	)

	(method (nextCel param1)
		(cond
			((== param1 0)
				(if (IsFlag 359)
					(= tracking 0)
					(global206 delete: self)
					(self doMouseUp:)
					(switch global243
						(0
							(scriptObj setScript: sBackEmpty)
						)
						(3
							(scriptObj setScript: sCenterBackFull)
						)
						(5
							(scriptObj setScript: sForwardCenterFull)
						)
						(2
							(scriptObj setScript: sForwardCenterEmpty)
						)
					)
				)
			)
			((and (== param1 10) (IsFlag 359))
				(= tracking 0)
				(global206 delete: self)
				(self doMouseUp:)
				(switch global243
					(4
						(scriptObj setScript: sBackCenterFull)
					)
					(1
						(scriptObj setScript: sBackCenterEmpty)
					)
					(0
						(scriptObj setScript: sCenterForwardEmpty)
					)
					(3
						(scriptObj setScript: sCenterForwardFull)
					)
				)
			)
		)
		(super nextCel: param1 &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					(cycler
						(if (== (cycler cycleDir:) 1)
							(self setCycle: Beg)
							(localSound number: 845 play:)
						else
							(self setCycle: End)
							(localSound number: 846 play:)
						)
					)
					(cel
						(self setCycle: Beg)
						(localSound number: 845 play:)
					)
					(else
						(self setCycle: End)
						(localSound number: 846 play:)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftPipeValve of Prop
	(properties
		x 54
		y 269
		loop 2
		view 2817
	)

	(method (cue)
		(if cel
			(ClearFlag 361)
			(ClearFlag 358)
			(leftDial setCycle: Beg)
			(if (IsFlag 269)
				(steamSound number: 928 play:)
				(if (not (IsFlag 301))
					(gateSound number: 938 play:)
				)
			)
			(SetFlag 301)
		else
			(SetFlag 361)
			(if (IsFlag 269)
				(SetFlag 358)
				(leftDial setCycle: End)
				(if (IsFlag 363)
					(ClearFlag 301)
					(gateSound number: 8431 play:)
				)
				(steamSound number: 927 play:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					(cycler
						(if (== (cycler cycleDir:) 1)
							(self setCycle: Beg self)
							(localSound number: 933 play:)
						else
							(self setCycle: End self)
							(localSound number: 932 play:)
						)
					)
					(cel
						(self setCycle: Beg self)
						(localSound number: 933 play:)
					)
					(else
						(self setCycle: End self)
						(localSound number: 932 play:)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vertPipeValve of Prop
	(properties
		x 173
		y 167
		loop 3
		view 2817
	)

	(method (cue)
		(if cel
			(ClearFlag 362)
			(ClearFlag 359)
			(rightDial setCycle: Beg)
			(if (IsFlag 268)
				(steamSound number: 928 play:)
			)
		else
			(SetFlag 362)
			(if (IsFlag 268)
				(SetFlag 359)
				(rightDial setCycle: End)
				(steamSound number: 927 play:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					(cycler
						(if (== (cycler cycleDir:) 1)
							(self setCycle: Beg self)
							(localSound number: 931 play:)
						else
							(self setCycle: End self)
							(localSound number: 930 play:)
						)
					)
					(cel
						(self setCycle: Beg self)
						(localSound number: 931 play:)
					)
					(else
						(self setCycle: End self)
						(localSound number: 930 play:)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftDial of Prop
	(properties
		x 128
		y 249
		loop 1
		view 2818
	)
)

(instance rightDial of Prop
	(properties
		x 163
		y 246
		loop 2
		view 2818
	)
)

(instance craneButton of Prop
	(properties
		x 138
		y 280
		loop 3
		view 2818
	)

	(method (cue)
		(switch global243
			(1
				(scriptObj setScript: sLiftRock)
			)
			(5
				(scriptObj setScript: sDropRock)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self setCel: 0 setCycle: End self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance magnet2813 of Prop ; UNUSED
	(properties
		x 300
		y 1
		loop 4
		view 2817
	)
)

(instance cageLever of View
	(properties
		x 362
		y 128
		view 2818
	)
)

(instance moveThruGate of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 108 299 114 155 253 161 252 299
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pUmbrellaProp of Prop
	(properties
		x 196
		y 78
		view 2821
	)

	(method (cue)
		(ClearFlag 396)
		(gInventory addItem: (ScriptID 9 6)) ; invUmbrella
		(moveThruGate dispose:)
		(if (not (IsFlag 377))
			(= global245 (rockBot curFrame:))
			(rockBot caller: 0 dispose:)
			(rockBot init: 2821 0 0 0 -1 curFrame: global245)
			(if (IsFlag 270)
				(rockBot start: 1 10 1)
			)
			(fUmbrellaHole init:)
		else
			(rockBot curFrame: 0 init: 2823 0 0 0 -1)
			(fOpenTheGate init:)
		)
		(gateSlamSound play:)
		(gGame handsOn:)
		(fUmbrella dispose:)
		(self dispose:)
	)
)

(instance fUmbrella of Feature
	(properties
		x 228
		y 60
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 179 77 194 96 250 73 278 40 249 25 209 28
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(pUmbrellaProp setCycle: Beg pUmbrellaProp)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fUmbrellaHole of Feature
	(properties
		x 199
		y 74
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 173 102 189 111 214 100 226 80 225 52 213 43 187 51 173 71
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; invUmbrella
				(if ((ScriptID 9 6) state:) ; invUmbrella
					(super doVerb: theVerb &rest)
				else
					(gGame handsOff:)
					(scriptObj setScript: sTryUmbrella)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sTryUmbrella of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pUmbrellaProp cel: 0 init: setPri: 300 setCycle: CT 1 1 self)
			)
			(1
				(if
					(or
						(OneOf global245 3 4 5 6 43 44 45 46 82 83 84 85)
						(IsFlag 377)
					)
					(pUmbrellaProp setCycle: End self)
					(if (not (IsFlag 377))
						(= global245 (rockBot curFrame:))
						(rockBot caller: 0 dispose:)
						(rockBot
							init: 2822 0 0 0 -1
							curFrame: global245
							start: 1 10 1
						)
					)
				else
					(pUmbrellaProp setCycle: Beg self)
				)
			)
			(2
				(if (pUmbrellaProp cel:)
					(SetFlag 396)
					(gInventory deleteItem: (ScriptID 9 6)) ; invUmbrella
					(fUmbrella init:)
					(fUmbrellaHole dispose:)
					(moveThruGate newPic: 2815 4)
				else
					(moveThruGate dispose:)
					(pUmbrellaProp dispose:)
					(fUmbrella dispose:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fOpenTheGate of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 108 299 114 155 253 161 252 299
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(scriptObj setScript: sOpenTheGate)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance sOpenTheGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localSound number: 933 setLoop: 1 play:)
				(rockBot caller: self cycleTo: 2 1 10)
			)
			(1
				(gGame handsOn:)
				(fOpenTheGate dispose:)
				(fUmbrellaHole init:)
				(= seconds 6)
			)
			(2
				(if
					(or
						(gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(> (gPanels size:) 1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(gGame handsOff:)
				(rockBot caller: self cycleTo: 0 -1 10)
				(gateSlamSound play:)
			)
			(4
				(fOpenTheGate init:)
				(fUmbrellaHole dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance vTrainGate of View
	(properties
		x 402
		y 97
		view 2816
	)
)

(instance sBabyRandom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 6 10))
				(babySound play:)
			)
			(1
				(client setCel: 0 setCycle: End self)
			)
			(2
				(if (Random 0 5)
					(= state 0)
				else
					(= state -1)
				)
				(self cue:)
			)
		)
	)
)

(instance localSound of Sound
	(properties)
)

(instance beltSound of Sound
	(properties
		number 840
	)
)

(instance swingDoorSound of Sound
	(properties
		number 847
	)
)

(instance gateSlamSound of Sound
	(properties
		number 848
	)
)

(instance craneSound of Sound
	(properties
		number 934
		loop -1
	)
)

(instance hornSound of Sound
	(properties
		number 838
	)
)

(instance gateSound of Sound
	(properties)
)

(instance babySound of Sound
	(properties
		number 839
	)
)

(instance babySound2 of Sound
	(properties
		number 842
	)
)

(instance trainSound of Sound
	(properties
		number 808
		loop -1
	)
)

(instance rockSmashSound of Sound
	(properties
		number 841
	)
)

(instance steamSound of Sound
	(properties)
)

