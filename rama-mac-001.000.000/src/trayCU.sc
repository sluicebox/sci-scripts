;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2032)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use Button)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	trayCU 0
)

(procedure (localproc_0 &tmp temp0)
	(if (not (localproc_4))
		(return 0)
	)
	(if (not (-- global200))
		(if
			(>
				(= temp0 (+ (>> ((ScriptID 200 0) curCornDispenser:) $0008) 1)) ; cplainRegion
				2
			)
			(= temp0 0)
		)
		((ScriptID 200 0) curCornDispenser: (| (<< temp0 $0008) $0001)) ; cplainRegion
	)
	(return (localproc_3))
)

(procedure (localproc_1 param1)
	(param1 doVerb: 41)
	(localproc_0)
)

(procedure (localproc_2)
	(if (not (IsFlag 59))
		(return 0)
	)
	((ScriptID 200 0) curInvItemInStill: (proc70_7 (gTheCursor invItem:))) ; cplainRegion
	(placeItemSound play:)
	(proc70_3)
	(return 1)
)

(procedure (localproc_3)
	(if (localproc_4)
		(if (< (fluidLevel cel:) global200)
			(fluidLevel setCycle: CT global200 1)
		else
			(fluidLevel setCycle: CT global200 -1)
		)
	else
		(fluidLevel setCycle: CT 0 -1)
	)
)

(procedure (localproc_4)
	(if (and (IsFlag 60) (== (proc70_9 34) 2017) (> global200 0))
		(gUser input:)
	)
)

(instance trayCU of CloseupLocation
	(properties
		noun 1
		picture 2199
		heading 135
	)

	(method (init)
		(super init: picture)
		(dirtyTray init: global117)
		(stillButton init: global117)
		(fluidLevel init: global117)
		(stillButton init: global117)
		(tray init:)
		(if ((ScriptID 200 0) curInvItemInStill:) ; cplainRegion
			(itemInStill init: global117)
		)
	)
)

(instance stillButton of Button
	(properties
		x 254
		y 194
		view 2199
		loop 4
		cel 7
		upCel 7
		downCel 8
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 252 213 267 194 276 195 284 214 279 222 257 221
					yourself:
				)
			setHotspot: 2
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(buttonSound play:)
				(cond
					((not (localproc_4)) 0)
					((not (SetFlag 59))
						(localproc_0)
						(gCurRoom setScript: cleanTray)
					)
					(((ScriptID 200 0) curInvItemInStill:) ; cplainRegion
						(= temp0
							(proc70_6 ((ScriptID 200 0) curInvItemInStill:)) ; cplainRegion
						)
						(if (OneOf (temp0 verb:) 40 38 39)
							(localproc_0)
							(gCurRoom setScript: cleanInvItem)
							(localproc_1 temp0)
						)
					)
					(else
						(localproc_0)
						(gCurRoom setScript: cleanNothing)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fluidLevel of Prop
	(properties
		x 189
		y 221
		view 2199
		loop 4
	)

	(method (init)
		(if (not (IsFlag 60))
			(return)
		)
		(= cel global200)
		(super init: &rest)
	)
)

(instance itemInStill of Prop
	(properties
		view 2199
	)

	(method (init)
		(if (not ((ScriptID 200 0) curInvItemInStill:)) ; cplainRegion
			(return)
		)
		(switch ((proc70_6 ((ScriptID 200 0) curInvItemInStill:)) verb:) ; cplainRegion
			(40
				(self setLoop: 0 cel: 0 x: 331 y: 173)
			)
			(39
				(self setLoop: 0 cel: 0 x: 331 y: 173)
			)
			(38
				(self setLoop: 2 cel: 0 x: 332 y: 173)
			)
			(else
				(if
					(OneOf
						((proc70_6 ((ScriptID 200 0) curInvItemInStill:)) verb:) ; cplainRegion
						74
						75
						76
						77
						78
						70
						71
						130
						72
						73
						47
						46
					)
					(self setLoop: 2 cel: 48 x: 332 y: 173)
				else
					(self setLoop: 0 cel: 48 x: 331 y: 173)
				)
			)
		)
		(super init: &rest)
	)
)

(instance dirtyTray of Prop
	(properties)

	(method (init)
		(if (IsFlag 59)
			(return)
		)
		(self view: 2199 loop: 1 cel: 0 x: 333 y: 172)
		(super init: &rest)
	)
)

(instance nothingInTray of Prop
	(properties
		x 332
		y 216
		view 2199
		loop 3
	)
)

(instance tray of Feature
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 298 241 355 239 385 258 382 261 326 264
					yourself:
				)
		)
		(if ((ScriptID 200 0) curInvItemInStill:) ; cplainRegion
			(self setHotspot: 2)
		else
			(self setHotspot: 40 38 39)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if ((ScriptID 200 0) curInvItemInStill:) ; cplainRegion
					(proc70_1 ((ScriptID 200 0) curInvItemInStill:) 0) ; cplainRegion
					((ScriptID 200 0) curInvItemInStill: 0) ; cplainRegion
					(itemInStill dispose:)
					(self setHotspot: 40 38 39)
				)
			)
			(40
				(if (localproc_2)
					(self setHotspot: 2)
					(itemInStill init: global117)
				else
					(gMessager say: 24 144 0 0 0 210) ; "The tray looks like it could use a good cleaning."
				)
			)
			(38
				(if (localproc_2)
					(self setHotspot: 2)
					(itemInStill init: global117)
				else
					(gMessager say: 24 144 0 0 0 210) ; "The tray looks like it could use a good cleaning."
				)
			)
			(39
				(if (localproc_2)
					(self setHotspot: 2)
					(itemInStill init: global117)
				else
					(gMessager say: 24 144 0 0 0 210) ; "The tray looks like it could use a good cleaning."
				)
			)
			(1
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cleanTray of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cleanItemSound play:)
				(dirtyTray setCycle: End self)
			)
			(1
				(gMessager say: 24 144 1 0 0 210) ; "The tray is quite clean now"
				0
				(dirtyTray dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cleanInvItem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cleanItemSound play:)
				(itemInStill setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cleanNothing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cleanItemSound play:)
				(nothingInTray cel: 0 init: global117 setCycle: End self)
			)
			(1
				(nothingInTray dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance watchFluid of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance buttonSound of Sound
	(properties
		flags 5
		number 2203
	)
)

(instance cleanItemSound of Sound
	(properties
		flags 5
		number 2202
	)
)

(instance placeItemSound of Sound
	(properties
		flags 5
		number 2201
	)
)

