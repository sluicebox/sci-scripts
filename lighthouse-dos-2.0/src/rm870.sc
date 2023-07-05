;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 870)
(include sci.sh)
(use Main)
(use LightRoom)
(use PanelPlane)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm870 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm870 of LightRoom
	(properties
		picture 871
	)

	(method (init)
		(Lock rsAUDIO 851 1)
		(Lock rsAUDIO 852 1)
		(Lock rsAUDIO 879 1)
		(Lock rsAUDIO 880 1)
		(Lock rsAUDIO 881 1)
		(Lock rsAUDIO 882 1)
		(Lock rsAUDIO 883 1)
		(Lock rsAUDIO 927 1)
		(Lock rsAUDIO 928 1)
		(gGame handsOn:)
		(super init: &rest)
		(gBackMusic number: 8003 setLoop: -1 play:)
		(switch gPrevRoomNum
			(270
				(self changeScene: 871 3)
				(if (IsFlag 402)
					(trainSound play:)
				)
			)
			(880
				(if (IsFlag 320)
					(gCurRoom drawPic: 878)
					(proc0_8 885)
				)
				(= local0 1)
				(ClearFlag 264)
				(self changeScene: 878 5)
			)
			(else
				(self changeScene: 871 3)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(Lock rsAUDIO 851 0)
		(Lock rsAUDIO 852 0)
		(Lock rsAUDIO 879 0)
		(Lock rsAUDIO 880 0)
		(Lock rsAUDIO 881 0)
		(Lock rsAUDIO 882 0)
		(Lock rsAUDIO 883 0)
		(Lock rsAUDIO 927 0)
		(Lock rsAUDIO 928 0)
		(if (== newRoomNumber 270)
			(ClearFlag 268)
			(ClearFlag 269)
			(ClearFlag 270)
			(ClearFlag 271)
			(ClearFlag 272)
			(ClearFlag 273)
			(ClearFlag 274)
			(ClearFlag 301)
			(if (not (IsFlag 275))
				(if (IsFlag 277)
					(SetFlag 270)
				)
				(if (IsFlag 278)
					(SetFlag 269)
				else
					(SetFlag 301)
				)
				(if (IsFlag 279)
					(SetFlag 268)
				)
			else
				(SetFlag 301)
			)
			(if (not (IsFlag 276))
				(if (IsFlag 280)
					(SetFlag 271)
				)
				(if (IsFlag 281)
					(SetFlag 272)
				)
				(if (IsFlag 282)
					(SetFlag 273)
				)
				(if (IsFlag 283)
					(SetFlag 274)
				)
			)
		)
		(trainSound stop:)
		(super newRoom: newRoomNumber &rest)
	)

	(method (changeScene param1)
		(movieForward dispose:)
		(v879Walkway dispose:)
		(f879Walkway dispose:)
		(p879Lava dispose:)
		(p872LeftCog dispose:)
		(p872RightCog dispose:)
		(p872Lever dispose:)
		(p876Sphere dispose:)
		(p876Lever dispose:)
		(v874Sphere dispose:)
		(p874SphereDoor dispose:)
		(movieForward880 dispose:)
		(f874OpenDoor dispose:)
		(f4800Sphere dispose:)
		(p873MagnetCrane0 dispose:)
		(p873TrainGate1 dispose:)
		(p873ConveyorBelt2 dispose:)
		(p873SouthDoor3 dispose:)
		(p873GateDevice4 dispose:)
		(p873RoundTable5 dispose:)
		(p873EastDoor6 dispose:)
		(p973RightEngine dispose:)
		(p973LeftEngine dispose:)
		(moveRightSpecial dispose:)
		(goForward4802 dispose:)
		(goForward871 dispose:)
		(trainATP dispose:)
		(fToolbox869 dispose:)
		(fToolbox870 dispose:)
		(fDiagram dispose:)
		(= local1 scene)
		(super changeScene: param1 &rest)
		(switch param1
			(869
				((ScriptID 1 1) ; exitForward
					newRoom: 270
					nsLeft: 111
					nsTop: 67
					nsRight: 205
					nsBottom: 244
				)
				((ScriptID 1 3) newPic: 871 3) ; exitLeft
				(fToolbox869 init:)
				(if (== local1 4802)
					(leftSound fade:)
					(rightSound fade:)
					(if (IsFlag 402)
						(trainSound play:)
					)
				)
			)
			(870
				((ScriptID 1 1) ; exitForward
					newRoom: 270
					nsLeft: 167
					nsTop: 80
					nsRight: 257
					nsBottom: 239
				)
				((ScriptID 1 3) newPic: 871 3) ; exitLeft
				(fToolbox870 init:)
				(if (== local1 4802)
					(leftSound fade:)
					(rightSound fade:)
					(if (IsFlag 402)
						(trainSound play:)
					)
				)
			)
			(871
				(goForward871 newPic: 872 3)
				(if (== global237 4)
					((ScriptID 1 4) newPic: 870 15) ; exitRight
				else
					((ScriptID 1 4) newPic: 869 15) ; exitRight
					(trainATP view: 4817 setPri: 300 x: 499 y: 0 init:)
				)
			)
			(872
				((ScriptID 1 1) newPic: 873 3) ; exitForward
				((ScriptID 1 2) newPic: 4802 7) ; exitBack
				((ScriptID 1 4) ; exitRight
					newPic: 4800 1
					nsLeft: 372
					nsTop: 138
					nsRight: 500
					nsBottom: 268
				)
				(if (not (IsFlag 275))
					(p872LeftCog init: setCycle: Fwd)
				)
				(if (not (IsFlag 276))
					(p872RightCog init: setCycle: Fwd)
				)
				(if (IsFlag 281)
					(p872Lever init: setCel: 0)
				else
					(p872Lever init: setCel: 1)
				)
				(FrameOut)
				(if (and (IsFlag 402) (== local1 871))
					(trainSound stop:)
				)
				(if (== local1 871)
					(if (not (IsFlag 275))
						(leftSound play: 0 0 fade: 127 26 7 0)
					)
					(if (not (IsFlag 276))
						(rightSound play: 0 0 fade: 127 26 7 0)
					)
				)
			)
			(873
				(p873MagnetCrane0 init:)
				(p873TrainGate1 init:)
				(p873ConveyorBelt2 init:)
				(p873SouthDoor3 init:)
				(p873GateDevice4 init:)
				(p873RoundTable5 init:)
				(p873EastDoor6 init:)
				((ScriptID 1 7) newPic: 872 3) ; exitBackUp
				(moveRightSpecial newPic: 4800 1)
				(lavaSound fade:)
				(if (not (IsFlag 275))
					(p973LeftEngine init: setCycle: Fwd)
				)
				(if (not (IsFlag 276))
					(p973RightEngine init: setCycle: Fwd)
				)
				(if (== local1 878)
					(if (not (IsFlag 275))
						(leftSound play: 0 0 fade: 127 26 7 0)
					)
					(if (not (IsFlag 276))
						(rightSound play: 0 0 fade: 127 26 7 0)
					)
				)
			)
			(874
				(if (== local1 876)
					(sPlaySound dispose:)
					(sphereSound stop:)
				)
				(if (IsFlag 254)
					(if (IsFlag 264)
						(f874OpenDoor init:)
						(movieForward880 init:)
						(p874SphereDoor cel: 48)
					else
						(p874SphereDoor cel: 0)
					)
					(p874SphereDoor init: setPri: 300)
					(v874Sphere init:)
				else
					(movieForward init:)
				)
				((ScriptID 1 2) newPic: 878 5) ; exitBack
				((ScriptID 1 4) newPic: 879 15) ; exitRight
				(if (== local1 4800)
					(leftSound fade:)
					(rightSound fade:)
				)
				(lavaSound play: 0 0 fade: 127 26 7 0)
			)
			(876
				((ScriptID 1 1) ; exitForward
					newPic: 874 1
					nsLeft: 33
					nsTop: 125
					nsRight: 133
					nsBottom: 295
				)
				(p876Sphere cel: (if (IsFlag 254) 51 else 0) init:)
				(p876Lever init:)
				(if (IsFlag 254)
					(p876Sphere setCel: 51)
					(p876Lever setCel: 6)
				)
			)
			(878
				(if (and (IsFlag 264) (== local1 874))
					(ClearFlag 264)
					(localSound number: 888 setLoop: 1 play:)
				)
				((ScriptID 1 1) ; exitForward
					newPic: 4802 7
					arrowStyle: 8
					nsLeft: 155
					nsTop: 47
					nsRight: 243
					nsBottom: 225
				)
				((ScriptID 1 4) ; exitRight
					newPic: 873 3
					arrowStyle: 7
					nsLeft: 244
					nsTop: 47
					nsRight: 332
					nsBottom: 225
				)
				((ScriptID 1 2) newPic: 874 1) ; exitBack
				((ScriptID 1 3) newPic: 879 15) ; exitLeft
				(if local0
					(= local0 0)
					(if (IsFlag 320)
						(ClearFlag 320)
					)
					(localSound number: 888 setLoop: 1 play:)
					(lavaSound play: 0 0 fade: 127 26 7 0)
				)
			)
			(879
				(if (and (IsFlag 264) (== local1 874))
					(ClearFlag 264)
					(localSound number: 888 setLoop: 1 play:)
				)
				((ScriptID 1 3) newPic: 874 1) ; exitLeft
				((ScriptID 1 4) newPic: 878 5) ; exitRight
				(if (IsFlag 255)
					((ScriptID 1 1) ; exitForward
						newPic: 876 11
						nsLeft: 245
						nsTop: 137
						nsRight: 430
						nsBottom: 277
					)
					(v879Walkway init:)
				else
					(f879Walkway init:)
				)
				(p879Lava init: setCycle: Fwd)
			)
			(4800
				(fDiagram init:)
				((ScriptID 1 1) newPic: 874 1) ; exitForward
				((ScriptID 1 4) newPic: 4802 7) ; exitRight
				((ScriptID 1 3) newPic: 873 3) ; exitLeft
				(if (IsFlag 254)
					(f4800Sphere init:)
				)
			)
			(4802
				(if (== global237 4)
					(goForward4802 newPic: 870 15)
				else
					(goForward4802 newPic: 869 15)
					(trainATP view: 4818 x: 231 y: 179 init:)
				)
				((ScriptID 1 3) newPic: 4800 1) ; exitLeft
				((ScriptID 1 2) newPic: 872 3) ; exitBack
				(lavaSound fade:)
				(FrameOut)
				(if (== local1 878)
					(if (not (IsFlag 275))
						(leftSound play: 0 0 fade: 127 26 7 0)
					)
					(if (not (IsFlag 276))
						(rightSound play: 0 0 fade: 127 26 7 0)
					)
				)
			)
		)
	)
)

(instance movieForward of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(= nsLeft 170)
		(= nsTop 100)
		(= nsRight 330)
		(= nsBottom 175)
		(= curDir 1)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (not local3)
			(super handleEvent: event &rest)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 24 5)) ; ???, Do
			(return)
		)
		(= local3 1)
		(proc0_8 875)
		(= local3 0)
	)
)

(instance fToolbox869 of Feature
	(properties
		x 298
		y 238
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 230 218 226 264 370 260 369 212
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				((ScriptID 271 0) init:) ; toolBoxPanel
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fToolbox870 of Feature
	(properties
		x 82
		y 246
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 218 156 214 164 265 0 278
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				((ScriptID 271 0) init:) ; toolBoxPanel
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trainATP of View
	(properties)
)

(instance v879Walkway of View
	(properties
		x 275
		y 292
		view 892
	)
)

(instance p879Lava of Prop
	(properties
		y 299
		view 4824
	)
)

(instance f879Walkway of Feature
	(properties
		x 344
		y 219
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 279 200 337 191 409 234 323 248
					yourself:
				)
		)
		(super init: &rest)
		(approachX hotVerbs: 5 10)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (IsFlag 255))
					(walkwayPanel init:)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(10 ; invUmbrella
				(if (not (IsFlag 255))
					(walkwayPanel init:)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance walkwayPanel of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(self setBitmap: 877 0 0)
		(ppWalkway init: self 1 1 setCel: 0 setPri: 200)
		(ppBolt init: self 1 1 x: 1000 setCel: 0 setPri: 200)
		(global105 delete: (bitmap approachX:))
	)

	(method (dispose)
		(gCurRoom setScript: 0)
		(super dispose: &rest)
	)
)

(instance ppWalkway of PanelProp
	(properties
		loop 1
		view 877
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 10)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; invUmbrella
				(if ((ScriptID 9 6) state:) ; invUmbrella
					(super doVerb: theVerb &rest)
				else
					(gGame handsOff:)
					(if (and (== loop 1) (== cel 0))
						(gGame handsOff:)
						(gCurRoom setScript: sPullUpRamp)
					else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sPullUpRamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localSound number: 855 setLoop: 1 play:)
				(ppWalkway setCycle: CT 14 1 self)
			)
			(1
				(gGame handsOn:)
				(global105 delete: (ppBolt approachX:))
				(global105 addToFront: (ppBolt approachX:))
				(ppBolt x: 145)
				(= seconds 4)
			)
			(2
				(if (IsFlag 255)
					(self dispose:)
				else
					(gGame handsOff:)
					(ppBolt x: 1000)
					(ppWalkway setCycle: End self)
				)
			)
			(3
				(ppWalkway setLoop: 1 setCel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ppBolt of PanelProp
	(properties
		x 145
		y 86
		loop 2
		view 877
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(v879Walkway init:)
		((ScriptID 1 1) ; exitForward
			newPic: 876 1
			nsLeft: 245
			nsTop: 137
			nsRight: 430
			nsBottom: 277
		)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (IsFlag 255))
					(gGame handsOff:)
					(SetFlag 255)
					(localSound number: 856 setLoop: 1 play:)
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance p872LeftCog of Prop
	(properties
		x 24
		y 115
		view 4810
	)
)

(instance p872RightCog of Prop
	(properties
		x 151
		y 115
		view 4814
	)
)

(instance p872Lever of Prop
	(properties
		x 243
		y 212
		loop 1
		view 4814
	)
)

(instance p876Lever of Prop
	(properties
		x 354
		y 244
		view 884
	)

	(method (cue)
		(if cel
			(p876Sphere setCycle: End p876Sphere)
			(SetFlag 254)
		else
			(p876Sphere setCycle: Beg p876Sphere)
			(ClearFlag 254)
		)
		(gCurRoom setScript: sPlaySound)
		(gGame handsOn:)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if cycler
					(sphereSound number: 885 setLoop: 1 play:)
				)
				(if cel
					(self setCycle: Beg self)
				else
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance p876Sphere of Prop
	(properties
		x 177
		y 298
		loop 1
		view 884
	)

	(method (cue)
		(sphereSound stop:)
		(sphereSound2 number: 885 setLoop: 1 play:)
	)

	(method (dispose)
		(sphereSound stop:)
		(sphereSound2 stop:)
		(super dispose: &rest)
	)
)

(instance sPlaySound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sphereSound number: 857 setLoop: 1 play: 127 self)
			)
			(1
				(sphereSound number: 884 setLoop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance v874Sphere of View
	(properties
		x 159
		y 232
		view 894
	)
)

(instance p874SphereDoor of Prop
	(properties
		x 139
		y 343
		loop 1
		view 894
		z 150
	)

	(method (cue)
		(if local2
			(= local2 0)
			(localSound number: 887 setLoop: 1 play:)
			(self setCycle: End self)
		else
			(gGame handsOn:)
		)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not cel)
					(gGame handsOff:)
					(f874OpenDoor init:)
					(movieForward880 init:)
					(SetFlag 264)
					(= local2 1)
					(localSound number: 886 setLoop: 1 play:)
					(self setCycle: CT 29 1 self)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance movieForward880 of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(= nsLeft 220)
		(= nsTop 90)
		(= nsRight 276)
		(= nsBottom 174)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 24 5)) ; ???, Do
			(return)
		)
		(gBackMusic fade:)
		(gCurRoom newRoom: 880)
	)
)

(instance f874OpenDoor of Feature
	(properties
		x 176
		y 133
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 166 81 144 98 145 143 155 185 209 185 209 89 198 81
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (cue)
		(if local2
			(= local2 0)
			(localSound number: 888 setLoop: 1 play:)
			(p874SphereDoor setCycle: Beg self)
		else
			(gGame handsOn:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(ClearFlag 264)
				(Load rsAUDIO 888)
				(= local2 1)
				(Load rsAUDIO 888)
				(p874SphereDoor setCycle: CT 31 -1 self)
				(movieForward880 dispose:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance f4800Sphere of View
	(properties
		x 221
		y 202
		view 4800
	)
)

(instance moveRightSpecial of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 0)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 500 90 440 90 440 210 500 210 500 198 464 198 448 180 446 165 457 148 473 147 500 146
					yourself:
				)
		)
		(super init: &rest)
	)
)

(class ValveProp of Prop
	(properties
		openCel 0
		squeakCel1 -1
		squeakCel2 -1
		squeakSound 0
	)

	(method (turnOn)
		(steamSound number: 927 play:)
	)

	(method (turnOff)
		(steamSound number: 928 play:)
	)

	(method (doit)
		(if (and (or (== cel squeakCel1) (== cel squeakCel2)) cycler)
			(valveSound number: squeakSound play:)
		)
		(super doit: &rest)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					(cycler
						(if (== (cycler cycleDir:) -1)
							(self setCycle: End)
							(if openCel
								(self turnOn:)
							else
								(self turnOff:)
							)
						else
							(self setCycle: Beg)
							(if openCel
								(self turnOff:)
							else
								(self turnOn:)
							)
						)
					)
					(cel
						(self setCycle: Beg)
						(if openCel
							(self turnOff:)
						else
							(self turnOn:)
						)
					)
					(else
						(self setCycle: End)
						(if openCel
							(self turnOn:)
						else
							(self turnOff:)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance p873MagnetCrane0 of ValveProp
	(properties
		x 4
		y 278
		view 4812
		openCel 1
		squeakCel1 5
		squeakCel2 10
		squeakSound 851
	)

	(method (init)
		(cond
			((IsFlag 277)
				(if openCel
					(= cel 14)
				else
					(= cel 0)
				)
			)
			(openCel
				(= cel 0)
			)
			(else
				(= cel 14)
			)
		)
		(super init: &rest)
	)

	(method (turnOn)
		(SetFlag 277)
		(super turnOn: &rest)
	)

	(method (turnOff)
		(ClearFlag 277)
		(super turnOff: &rest)
	)
)

(instance p873TrainGate1 of ValveProp
	(properties
		x 89
		y 262
		loop 1
		view 4812
		squeakCel1 3
		squeakCel2 7
		squeakSound 852
	)

	(method (init)
		(cond
			((IsFlag 278)
				(if openCel
					(= cel 14)
				else
					(= cel 0)
				)
			)
			(openCel
				(= cel 0)
			)
			(else
				(= cel 14)
			)
		)
		(super init: &rest)
	)

	(method (turnOn)
		(SetFlag 278)
		(super turnOn: &rest)
	)

	(method (turnOff)
		(ClearFlag 278)
		(super turnOff: &rest)
	)
)

(instance p873ConveyorBelt2 of ValveProp
	(properties
		x 157
		y 220
		loop 2
		view 4812
		squeakCel1 4
		squeakCel2 8
		squeakSound 879
	)

	(method (init)
		(cond
			((IsFlag 279)
				(if openCel
					(= cel 14)
				else
					(= cel 0)
				)
			)
			(openCel
				(= cel 0)
			)
			(else
				(= cel 14)
			)
		)
		(super init: &rest)
	)

	(method (turnOn)
		(SetFlag 279)
		(super turnOn: &rest)
	)

	(method (turnOff)
		(ClearFlag 279)
		(super turnOff: &rest)
	)
)

(instance p873SouthDoor3 of ValveProp
	(properties
		x 262
		y 239
		loop 3
		view 4812
		openCel 1
		squeakCel1 1
		squeakCel2 11
		squeakSound 880
	)

	(method (init)
		(cond
			((IsFlag 280)
				(if openCel
					(= cel 14)
				else
					(= cel 0)
				)
			)
			(openCel
				(= cel 0)
			)
			(else
				(= cel 14)
			)
		)
		(super init: &rest)
	)

	(method (turnOn)
		(SetFlag 280)
		(super turnOn: &rest)
	)

	(method (turnOff)
		(ClearFlag 280)
		(super turnOff: &rest)
	)
)

(instance p873GateDevice4 of ValveProp
	(properties
		x 318
		y 220
		loop 4
		view 4812
		openCel 1
		squeakCel1 2
		squeakSound 883
	)

	(method (init)
		(cond
			((IsFlag 281)
				(if openCel
					(= cel 14)
				else
					(= cel 0)
				)
			)
			(openCel
				(= cel 0)
			)
			(else
				(= cel 14)
			)
		)
		(super init: &rest)
	)

	(method (turnOn)
		(SetFlag 281)
		(super turnOn: &rest)
	)

	(method (turnOff)
		(ClearFlag 281)
		(super turnOff: &rest)
	)
)

(instance p873RoundTable5 of ValveProp
	(properties
		x 382
		y 180
		loop 5
		view 4812
		squeakCel1 5
		squeakCel2 13
		squeakSound 881
	)

	(method (init)
		(cond
			((IsFlag 282)
				(if openCel
					(= cel 14)
				else
					(= cel 0)
				)
			)
			(openCel
				(= cel 0)
			)
			(else
				(= cel 14)
			)
		)
		(super init: &rest)
	)

	(method (turnOn)
		(SetFlag 282)
		(super turnOn: &rest)
	)

	(method (turnOff)
		(ClearFlag 282)
		(super turnOff: &rest)
	)
)

(instance p873EastDoor6 of ValveProp
	(properties
		x 453
		y 199
		loop 6
		view 4812
		openCel 1
		squeakCel1 6
		squeakCel2 14
		squeakSound 882
	)

	(method (init)
		(cond
			((IsFlag 283)
				(if openCel
					(= cel 14)
				else
					(= cel 0)
				)
			)
			(openCel
				(= cel 0)
			)
			(else
				(= cel 14)
			)
		)
		(super init: &rest)
	)

	(method (turnOn)
		(SetFlag 283)
		(super turnOn: &rest)
	)

	(method (turnOff)
		(ClearFlag 283)
		(super turnOff: &rest)
	)
)

(instance p973LeftEngine of Prop
	(properties
		x 79
		y 37
		view 4816
	)
)

(instance p973RightEngine of Prop
	(properties
		x 270
		y 32
		loop 1
		view 4816
	)
)

(instance goForward4802 of ExitFeature
	(properties
		x 270
		y 217
	)

	(method (init)
		(= arrowStyle 3)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 158 249 195 176 275 135 349 179 382 249
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance goForward871 of ExitFeature
	(properties
		x 264
		y 210
	)

	(method (init)
		(= arrowStyle 3)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 157 299 157 153 266 122 372 187 365 299
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftSound of Sound
	(properties
		number 849
		loop -1
	)
)

(instance rightSound of Sound
	(properties
		number 850
		loop -1
	)
)

(instance valveSound of Sound
	(properties)
)

(instance lavaSound of Sound
	(properties
		number 854
		loop -1
	)
)

(instance localSound of Sound
	(properties)
)

(instance sphereSound2 of Sound
	(properties)
)

(instance steamSound of Sound
	(properties)
)

(instance trainSound of Sound
	(properties
		number 808
		loop -1
	)
)

(instance sphereSound of Sound
	(properties)
)

(instance fDiagram of Feature
	(properties
		x 437
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 388 109 486 109 486 172 388 172
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(pplDiagram init:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pplDiagram of PanelPlane
	(properties)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			(self dispose:)
		)
		(event claimed: 1)
	)

	(method (init)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(= picture -1)
		(super init: 0 0 640 480)
		((PanelView new:) view: 4032 loop: 0 cel: 0 x: 15 y: 38 init: self)
	)
)

