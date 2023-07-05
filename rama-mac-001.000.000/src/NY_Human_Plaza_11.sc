;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5211)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SaveManager)
(use newYorkRegion)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	NY_Human_Plaza_11 0
)

(local
	local0
)

(instance NY_Human_Plaza_11 of Location
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5205 ; humanPlazaRm5
				(self addPicObj: faceNE faceSW faceNE)
			)
			(5401 ; NY_Subway_1
				(self addPicObj: faceSW faceNE faceSW)
				(gCurRoom setScript: doorShutsNow)
			)
			(else
				(self addPicObj: faceSW faceNE faceSW)
			)
		)
	)

	(method (serialize param1)
		(if param1
			(super serialize: param1 0)
			(= local0 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local0)
		)
	)

	(method (dispose)
		(= local0 0)
		(super dispose: &rest)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5229
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(doorLock init:)
		(if local0
			(= picture 5255)
			(exitToSubway init:)
		)
		(walls_45 init:)
		(door_45 init:)
		(sensor_45 init:)
		(super init: &rest)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5230
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom5 init:)
		(walls_225 init:)
		(fork_225 init:)
		(pentahedron_225 init:)
		(super init: &rest)
	)
)

(instance exitToRoom5 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5205
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 9) local0)
			(gCurRoom setScript: doorShuts 0 nextRoom)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance exitToSubway of ExitFeature
	(properties
		nsLeft 221
		nsTop 118
		nsRight 369
		nsBottom 270
		nextRoom 5401
	)
)

(instance doorLock of Feature
	(properties
		nsLeft 417
		nsTop 183
		nsRight 461
		nsBottom 227
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 139)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(139
				(proc201_1 29)
				(if local0
					(gCurRoom setScript: doorCloses)
				else
					(gCurRoom setScript: doorOpens)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorOpens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 1)
				(blue_Light_Close play:)
				(= cycles 1)
			)
			(1
				(subway_Opens play:)
				(= cycles 1)
			)
			(2
				(exitToSubway init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doorCloses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(blue_Light_Open play:)
				(= cycles 1)
			)
			(1
				(subway_Closes play:)
				(= cycles 1)
			)
			(2
				(exitToSubway dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doorShuts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(doorSnd number: 5212 setVol: 127 play: self)
			)
			(1
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance doorShutsNow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(doorSnd number: 5212 setVol: 127 play: self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance blue_Light_Close of VMDMovie
	(properties
		movieName 5201
	)
)

(instance blue_Light_Open of VMDMovie
	(properties
		movieName 5203
	)
)

(instance subway_Opens of VMDMovie
	(properties
		movieName 5202
		endPic 5255
	)
)

(instance subway_Closes of VMDMovie
	(properties
		movieName 5204
		endPic 5229
	)
)

(instance doorSnd of Sound
	(properties
		flags 5
	)
)

(instance walls_45 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 1 590 -2 590 282 587 281 559 271 53 265 36 274 0 273
					yourself:
				)
		)
	)
)

(instance door_45 of Feature
	(properties
		noun 1
	)

	(method (init)
		(= case (if (IsFlag 308) 2 else 1))
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 251 -2 335 -1 339 61 323 104 342 105 355 79 362 79 364 71 371 72 375 67 377 78 380 105 386 104 390 271 195 270 198 106 205 106 206 82 209 72 213 74 221 74 224 80 229 80 241 103 261 105 242 63
					yourself:
				)
		)
	)
)

(instance sensor_45 of Feature
	(properties
		noun 33
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 406 175 455 175 463 177 467 189 467 231 459 234 467 242 469 287 414 286 402 273 401 236 408 229 399 222 399 181 401 176
					yourself:
				)
		)
	)
)

(instance walls_225 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 2 590 1 590 180 395 183 394 187 374 187 373 194 201 194 -2 183
					yourself:
				)
		)
	)
)

(instance pentahedron_225 of Feature
	(properties
		noun 31
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -2 15 107 164 116 164 116 171 139 172 138 177 163 179 161 183 182 185 183 189 200 189 201 195 223 197 223 202 241 201 241 208 180 217 172 214 133 216 131 213 111 215 61 217 27 215 8 210 0 211
					yourself:
				)
		)
	)
)

(instance fork_225 of Feature
	(properties
		noun 29
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 285 99 298 99 298 153 294 157 293 178 303 185 305 194 273 194 276 187 285 179 288 179 286 156 284 153 283 142
					yourself:
				)
		)
	)
)

